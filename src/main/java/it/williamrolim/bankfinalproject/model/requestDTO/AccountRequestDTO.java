package it.williamrolim.bankfinalproject.model.requestDTO;

public class AccountRequestDTO {
	private String nameOwner;
	private String agencyCode;
	private String accountCode;
	private String digitVerification;
	private String registerId;
	
	public AccountRequestDTO() {}
	
	public AccountRequestDTO (String nameOwner, String agencyCode, String accountCode,
			String digitVerification) {

		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.digitVerification = digitVerification;
	}

	public AccountRequestDTO(String nameOwner, String agencyCode, String accountCode,
			String digitVerification, String registerId) {
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
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
	

}
