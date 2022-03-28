package it.williamrolim.bankfinalproject.responseDTO;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.TypeCard;

public class CardResponseDTO {
	
	private Integer id;
	private String name;
	private String flag;
	private String number;
	private String digit_code;
	private Double limit_balance;	
	private Account account;
	private TypeCard typeCard;
	
	public CardResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public CardResponseDTO(Integer id,String name, String flag, String number, String digit_code, Double limit_balance,
			Account account) {
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.number = number;
		this.digit_code = digit_code;
		this.limit_balance = limit_balance;
		this.account = account;
	}

	public CardResponseDTO(Integer id, String name, String flag, String number, String digit_code, Double limit_balance,
			TypeCard typeCard) {
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.number = number;
		this.digit_code = digit_code;
		this.limit_balance = limit_balance;
		this.typeCard = typeCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDigit_code() {
		return digit_code;
	}

	public void setDigit_code(String digit_code) {
		this.digit_code = digit_code;
	}

	public Double getLimit_balance() {
		return limit_balance;
	}

	public void setLimit_balance(Double limit_balance) {
		this.limit_balance = limit_balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TypeCard getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(TypeCard typeCard) {
		this.typeCard = typeCard;
	}
	
	
}
