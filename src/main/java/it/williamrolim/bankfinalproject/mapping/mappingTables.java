package it.williamrolim.bankfinalproject.mapping;

import java.util.ArrayList;
import java.util.List;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.responseDTO.AccountResponseDTO;
import it.williamrolim.bankfinalproject.responseDTO.TypeCardResponseDTO;

public class mappingTables {

//	public static AccountResponseDTO accountToAccountResponseDto(Account account) {
//		AccountResponseDTO accountResponseDto = new AccountResponseDTO ();
//		accountResponseDto.setId(account.getId());
//		accountResponseDto.setNameOwner(account.getNameOwner());
//		
//		List<Account> accounts = new ArrayList<>();
//		List<Card> cards = account.getCard();//temos que percorrer esses cartões e adicionar a lista de contas
//		for(Card card : cards) {
//			accounts.add(card.getAccount());
//		}
//		//agora temos que definir esses nomes de cartões para o cliente
//		accountResponseDto.setCard(cards);
//		return accountResponseDto;
//		
//	}
//	
//	public static List<AccountResponseDTO> accountsToAccountsResponseDtos(List<Account> accounts) {
//
//		List<AccountResponseDTO> accountResponseDto = new ArrayList<>();
//		for (Account account : accounts) {
//			accountResponseDto.add(accountToAccountResponseDto(account));
//		}
//		return accountResponseDto;
//	}
//
//	
//	public static TypeCardResponseDTO typeCardToTypeCardDto(TypeCard typecard) {
//		TypeCardResponseDTO typecardResponseDto = new TypeCardResponseDTO();
//		typecardResponseDto.setId(typecard.getId());
//		typecardResponseDto.setName(typecard.getName());
//		List<TypeCard> names = new ArrayList<>();
//		List<Card> cards = typecard.getCard();//temos que percorrer esses livros e adicionar a lista de nomes
//		for(Card card : cards) {
//			names.add(card.getTypeCard());
//		}
//		//agora temos que definir esses tipoes de cartão para os cartoes
//		typecardResponseDto.setCard(cards);
//		return typecardResponseDto;
//		
//	}
//	
//	public static List<TypeCardResponseDTO> typeCardToTypeCardResponseDtos(List<TypeCard> typecards) {
//
//		List<TypeCardResponseDTO> typecardResponseDto = new ArrayList<>();
//		for (TypeCard typecard : typecards) {
//			 typecardResponseDto.add(typeCardToTypeCardDto(typecard));
//		}
//		return typecardResponseDto;
//	}
}
