package it.williamrolim.bankfinalproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer account_id;

	@Basic
	@NotEmpty(message = "{campo.nameowner.obrigatorio}")
	@NotNull(message = "{campo.nameowner.obrigatorio}")
	@NotBlank(message = "{campo.nameowner.obrigatorio}")
	@Column(nullable = false, length  = 50)
	private String nameOwner;

	@Basic
	@Column(nullable = false, length = 4)
	@NotEmpty(message = "{campo.nameowner.obrigatorio}")
	@NotNull(message = "{campo.nameowner.obrigatorio}")
	@NotBlank(message = "{campo.nameowner.obrigatorio}")
	private String agencyCode;

	@Basic
	@Column(nullable = false,length = 8)
	@NotEmpty(message = "{campo.accountcode.obrigatorio}")
	@NotNull(message = "{campo.accountcode.obrigatorio}")
	@NotBlank(message = "{campo.accountcode.obrigatorio}")
	private String accountCode;

	@Basic
	@Column(nullable = false,length = 3)
	@NotEmpty(message = "{campo.digitVerification.obrigatorio}")
	@NotNull(message = "{campo.digitVerification.obrigatorio}")
	@NotBlank(message = "{campo.digitVerification.obrigatorio}")
	private String digitVerification;

	@Basic
	@Column(nullable = false,length = 18, unique = true)
	@Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$|^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$")
	@NotNull
	private String registerId;
//	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	 @OneToMany(mappedBy = "account" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	 private List<Card> card;

	// fetch = FetchType.LAZYnão tinha
	public Account() {

	}

	public Account(Integer account_id, String nameOwner, String agencyCode, String accountCode, String digitVerification,
			String registerId, List<Card> card) {
		this.account_id = account_id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
		this.card = card;
	}



	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
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
