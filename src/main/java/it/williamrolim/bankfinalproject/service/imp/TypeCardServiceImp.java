package it.williamrolim.bankfinalproject.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.TypeCardRequestDTO;
import it.williamrolim.bankfinalproject.repository.TypeCardRepository;
import it.williamrolim.bankfinalproject.service.TypeCardService;

@Service
public class TypeCardServiceImp implements TypeCardService {

	@Autowired
	TypeCardRepository typeCardRepository;

	@Transactional
	@Override
	public TypeCard insertTypeCard(TypeCardRequestDTO typeCardRequestDTO) {

		TypeCard typeCard = new TypeCard();
		typeCard.setName(typeCardRequestDTO.getName());
		String typecard = typeCard.getName();
		String result = typeCardRepository.findByName(typecard);
		
		  if ((result == null) || (result.equals(typecard))) {
			  typeCardRepository.save(typeCard);
		  }else {
				throw new RuntimeException("Error: Type Card Exist");
		  }
		return typeCard;
	}

	@Override
	public List<TypeCard> getAllTypeCards() {
		return StreamSupport.stream(typeCardRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public TypeCard getTypeCardId(Integer accountId) {
		return typeCardRepository.findById(accountId).orElseThrow(
				() -> new IllegalArgumentException("Type Card with id: " + accountId + " could not be found"));
	}

	@Override
	public void deleteTypeCard(Integer typeCardId) {

        Optional<TypeCard> typeCard = typeCardRepository.findById(typeCardId);
        
        typeCard.orElseThrow(() -> new RuntimeException("Type Card dont find"));

		typeCardRepository.deleteById(typeCardId);
	}

	@Transactional
	@Override
	public TypeCard updateTypeCard(Integer typecardID, TypeCardRequestDTO typeCardRequestDTO) {
		TypeCard typecardUpdate = getTypeCardId(typecardID);
		typecardUpdate.setName(typeCardRequestDTO.getName());
		if (typeCardRequestDTO.getId() != null) {
			return typeCardRepository.save(typecardUpdate);
		}
		return typecardUpdate;
	}

}
