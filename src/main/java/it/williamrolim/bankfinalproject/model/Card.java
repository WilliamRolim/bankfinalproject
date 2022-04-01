package it.williamrolim.bankfinalproject.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "card")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Basic
	@Column(nullable = false, length = 50)
	private String name;

	@Basic
	@Column(nullable = false, length = 45)
	private String flag;

	@Basic
	@Column(nullable = false, length = 45)
	private String numeros;

	@Basic
	@Column(nullable = false, length = 5)
	private String digit_code;

	@Basic
	@Column(columnDefinition = "Decimal(10,2) default '100.00'")
	private Double limit_balance;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id") // mudança de ultima hora account_id
	@JsonIgnore
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_card_id") // mudança de ultima hora type_card_id
	private TypeCard typeCard;

	public Card() {
	}

	public Card(Integer id, String name, String flag, String numeros, String digit_code, Double limit_balance,
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

	public Card(Integer id, String name, String flag, String numeros, String digit_code, Double limit_balance) {
		this.id = id;
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
