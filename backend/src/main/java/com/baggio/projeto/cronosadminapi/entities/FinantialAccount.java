package com.baggio.projeto.cronosadminapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_financial_account")
public class FinantialAccount implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private Double balance;
	private boolean bank;
	private String number;
	private String digit;
	private String agency;
	
	@Column(name = "digit_agency")
	private String digitAgency;
	
	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bankEntity;
	
	@OneToMany
	private List<FinantialHistoric> historics = new ArrayList<>();
	
	
	public FinantialAccount() {
	}

	public FinantialAccount(Long id, String description, Double balance, boolean bank, String number, String digit,
			String agency, String digitAgency, Bank bankEntity) {
		this.id = id;
		this.description = description;
		this.balance = balance;
		this.bank = bank;
		this.number = number;
		this.digit = digit;
		this.agency = agency;
		this.digitAgency = digitAgency;
		this.bankEntity = bankEntity;
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
	
	public Bank getBankEntity() {
		return bankEntity;
	}

	public void setBankEntity(Bank bankEntity) {
		this.bankEntity = bankEntity;
	}
	
	public List<FinantialHistoric> getHistorics() {
		return historics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinantialAccount other = (FinantialAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
