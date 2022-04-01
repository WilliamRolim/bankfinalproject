package it.williamrolim.bankfinalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.requestDTO.CardRequestDTO;
import it.williamrolim.bankfinalproject.responseDTO.CardResponseDTO;

@Service
public interface CardService  {
	
	public Card insertCard(CardRequestDTO cardRequestDto,Integer accountId, Integer typecardId);
	//public CardResponseDTO getCardId(Integer cardId);
	public Card getCardID(Integer cardId);
	public List<Card> getAllCards();
	public void deleteCard(Integer cardId);
	public Card updateCard(Integer cardId, CardRequestDTO cardRequestDTO);
	public CardResponseDTO addCardToAccount(Integer cardId, Long authorId);
	public CardResponseDTO addCardToTypeCard(Integer cardId, Long typeCardId);
	public CardResponseDTO removeCardToTypeCard(Integer typecardId, Integer cardId);
	public CardResponseDTO removeCardToAccount(Integer cardId, Integer accountId);
	

}
