package it.williamrolim.bankfinalproject.model.requestDTO;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.TypeCard;

public class CardRequestDTO {

	private Integer id;
	private String name;
	private String flag;
	private String numeros;
	private String digit_code;
	private Double limit_balance;	
	private Account account;
	private TypeCard typeCard;

	public CardRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	


	
	public CardRequestDTO(Integer id, String name, String flag, String numeros, String digit_code, Double limit_balance,
			Account account, TypeCard typeCard) {
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.numeros = numeros;
		this.digit_code = digit_code;
		this.limit_balance = limit_balance;
		this.account = account;
		this.typeCard = typeCard;
	}




	public CardRequestDTO(String name, String flag, String numeros, String digit_code, Double limit_balance,
			TypeCard typeCard) {
		this.name = name;
		this.flag = flag;
		this.numeros = numeros;
		this.digit_code = digit_code;
		this.limit_balance = limit_balance;
		
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



	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
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
