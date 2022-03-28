package it.williamrolim.bankfinalproject.responseDTO;

import java.util.List;

import it.williamrolim.bankfinalproject.model.Card;

public class AccountResponseDTO {
	
	private Integer id;
	private String nameOwner;
	private String agencyCode;
	private String accountCode;
	private String digitVerification;
	private String registerId;
	
	private List<Card> card;
	
	public AccountResponseDTO() {
		
	}
	public AccountResponseDTO(Integer id, String nameOwner, String agencyCode, String accountCode,
			String digitVerification, String registerId) {
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
	}
	
	public AccountResponseDTO(Integer id, String nameOwner, String agencyCode, String accountCode,
			String digitVerification, String registerId, List<Card> card) {
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
		this.card = card;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameOwner() {
		return nameOwner;
	}
	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getDigitVerification() {
		return digitVerification;
	}
	public void setDigitVerification(String digitVerification) {
		this.digitVerification = digitVerification;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	
}
