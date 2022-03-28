package it.williamrolim.bankfinalproject.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.CardRequestDTO;
import it.williamrolim.bankfinalproject.repository.AccontRepository;
import it.williamrolim.bankfinalproject.repository.CardRepository;
import it.williamrolim.bankfinalproject.repository.TypeCardRepository;
import it.williamrolim.bankfinalproject.responseDTO.CardResponseDTO;
import it.williamrolim.bankfinalproject.service.CardService;

@Service
public class CardServiceImp implements CardService {

	@Autowired
	AccontRepository accountRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	TypeCardRepository typeCardRepository;

	@Override
	public Card insertCard(CardRequestDTO cardRequestDto, Integer accountId, Integer typecardId) {
		Card card = new Card();
		Optional<Account> account = accountRepository.findById(accountId);
		account.orElseThrow(() -> new IllegalArgumentException("account with id: " + accountId + " could not be found"));

		Optional<TypeCard> typecard = typeCardRepository.findById(typecardId);
		account.orElseThrow(() -> new IllegalArgumentException("Type Card with id: " + typecardId + " could not be found"));

		card.setName(cardRequestDto.getName());
		card.setDigit_code(cardRequestDto.getDigit_code());
		card.setLimit_balance(cardRequestDto.getLimit_balance());
		card.setNumeros(cardRequestDto.getNumeros());
		card.setFlag(cardRequestDto.getFlag());

		card.setAccount(account.get());
		card.setTypeCard(typecard.get());

		return cardRepository.save(card);

	}

	@Override
	public Card getCardID(Integer cardId) {
		return cardRepository.findById(cardId)
				.orElseThrow(() -> new IllegalArgumentException("card with id: " + cardId + " could not be found"));
	}

	@Override
	public List<Card> getAllCards() {
		return StreamSupport.stream(cardRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Card deleteCard(Integer cardId) {

		Card account = getCardID(cardId);
		cardRepository.deleteById(cardId);
		return  account;
	}

	@Override
	public Card updateCard(Integer cardId, CardRequestDTO cardRequestDTO) {
		Optional<Card> cardID = cardRepository.findById(cardId);
		cardID.orElseThrow(() -> new IllegalArgumentException("card with id: " + cardId + " could not be found"));
			Card  cardUpdate =  getCardID(cardId);
			cardUpdate.setName(cardRequestDTO.getName());
			cardUpdate.setNumeros(cardRequestDTO.getNumeros());
			cardUpdate.setLimit_balance(cardRequestDTO.getLimit_balance());
			cardUpdate.setFlag(cardRequestDTO.getFlag());
			cardUpdate.setDigit_code(cardRequestDTO.getDigit_code());
			if ( cardId != null) {
				return cardRepository.save(cardUpdate);
			}
//		  if (typeCardRequestDTO.getId() != null) {
//	            return typeCardRepository.save(typecardUpdate);
//		  }
//	            return typecardUpdate;
		return cardUpdate;
	}

	@Override
	public CardResponseDTO addCardToAccount(Integer cardId, Long authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardResponseDTO addCardToTypeCard(Integer cardId, Long typeCardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardResponseDTO removeCardToTypeCard(Integer typecardId, Integer cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardResponseDTO removeCardToAccount(Integer cardId, Integer accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
