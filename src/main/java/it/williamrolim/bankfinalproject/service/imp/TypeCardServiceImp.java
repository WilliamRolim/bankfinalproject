package it.williamrolim.bankfinalproject.service.imp;

import java.util.List;
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
		
		return typeCardRepository.save(typeCard);


		// compareTwoTypeCard(typeCardRequestDTO);

//		
//		getTypeCardName(name);
//		
//			if (name != typeCardRequestDTO.getName()) {
//			typeCard.setName(typeCardRequestDTO.getName());
//		}else {
//			throw new RuntimeException("Type Card Já existe");
//		}

		// fazer no metodo Optional<TypeCard> tcname =
		// typeCardRepository.findIDByName(typeCardRequestDTO.getName());

//		if (tcname.get().getName() != typeCardRequestDTO.getName()) {
//			typeCard.setName(typeCardRequestDTO.getName());
//		}else {
//			throw new RuntimeException("Type Card Já existe");
//		}

//		//typeCard.setId(typeCardRequestDTO.getId());
//		Optional<TypeCard> tc = typeCardRepository.findIDByName(typeCardRequestDTO.getName());
//		typeCard.setType_card_id(tc.get().getType_card_id());
//		if ((tc.get().getName() != null)|| typeCardRequestDTO.getName() == tc.get().getName())
//			throw new RuntimeException("Type Card is Null or Blank or No Name");
//				//id.orElseThrow(() -> new RuntimeException("id dont find"));
//		Integer id = tc.get().getType_card_id();
//		System.out.println("VEJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + id);
//		typeCard.setName(tc.get().getName());

	}

//	@SuppressWarnings("unlikely-arg-type")
//	@Override
//	public Boolean getTypeCardName(String name) {
//		Optional<TypeCard> tc = typeCardRepository.findByName(name);
//		Objects.equals("test", new String("test"))
//		if (tc.get().getName().equalsIgnoreCase(name)) {
//			
//		}
//		return true;
//	}

	@Override
	public List<TypeCard> getAllTypeCards() {
		return StreamSupport.stream(typeCardRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public TypeCard getTypeCardId(Integer accountId) {
		return typeCardRepository.findById(accountId).orElseThrow(
				() -> new IllegalArgumentException("account with id: " + accountId + " could not be found"));
	}

	@Override
	public void deleteTypeCard(Integer typeCardId) {
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

	@Override
	public TypeCard searchName(TypeCardRequestDTO typeCardRequestDTO) {
		TypeCard typeCard = new TypeCard();
		typeCard.setName(typeCardRequestDTO.getName());
		String name = typeCard.getName();

		String result = typeCardRepository.findByName(name);

		if (result == null || (result.equals(name))) {
			insertTypeCard(typeCardRequestDTO);

			try {
				if (result == name) {
					throw new RuntimeException("Type Card Já existe");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

}
