package it.williamrolim.bankfinalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.TypeCardRequestDTO;
@Service
public interface TypeCardService {
	
    public TypeCard insertTypeCard(TypeCardRequestDTO typeCardRequestDTO);
    public List<TypeCard> getAllTypeCards();
    public TypeCard getTypeCardId(Integer typecardId);
    public void deleteTypeCard(Integer typecardId);
    public TypeCard updateTypeCard(Integer typecardId, TypeCardRequestDTO typeCardRequestDTO);
    //public TypeCard searchName(TypeCardRequestDTO typeCardRequestDTO);
    //    public TypeCard addCardToAccount(Long accountId, Long cardId);
//    public TypeCard removeCardFromAccount(Long zipcodeId);
	//public TypeCard compareTwoTypeCard(TypeCardRequestDTO typecardRequestDTO);
}
