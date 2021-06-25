package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baggio.projeto.cronosadminapi.entities.FinantialAccount;
import com.baggio.projeto.cronosadminapi.services.validation.FinantialAccountValid;

@FinantialAccountValid
public class FinantialAccountDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@NotNull(message = "Campo obrigatório")
	private Double balance;
	
	private boolean bank;
	
	@Size(max = 20, message = "Deve conter no máximo 20 caracteres")
	private String number;
	
	@Size(max = 2, message = "Deve conter no máximo 2 caracteres")
	private String digit;
	
	@Size(max = 20, message = "Deve conter no máximo 20 caracteres")
	private String agency;
	
	@Size(max = 20, message = "Deve conter no máximo 2 caracteres")
	private String digitAgency;
	
	private Long bankId;
	
	public FinantialAccountDTO() {

	}

	public FinantialAccountDTO(Long id, String description, Double balance, boolean bank, String number, String digit,
			String agency, String digitAgency, Long bankId) {
		this.id = id;
		this.description = description;
		this.balance = balance;
		this.bank = bank;
		this.number = number;
		this.digit = digit;
		this.agency = agency;
		this.digitAgency = digitAgency;
		this.bankId = bankId;
	}
	
	public FinantialAccountDTO(FinantialAccount entity) {
		id = entity.getId();
		description = entity.getDescription();
		balance = entity.getBalance();
		bank = entity.isBank();
		number = entity.getNumber();
		digit = entity.getDigit();
		agency = entity.getAgency();
		digitAgency = entity.getDigitAgency();
		
		if(entity.getBankEntity() != null) {
			bankId = entity.getBankEntity().getId();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public boolean isBank() {
		return bank;
	}

	public void setBank(boolean bank) {
		this.bank = bank;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDigit() {
		return digit;
	}

	public void setDigit(String digit) {
		this.digit = digit;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getDigitAgency() {
		return digitAgency;
	}

	public void setDigitAgency(String digitAgency) {
		this.digitAgency = digitAgency;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

}
