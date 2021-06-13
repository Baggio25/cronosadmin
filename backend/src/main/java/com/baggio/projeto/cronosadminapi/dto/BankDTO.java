package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;

import com.baggio.projeto.cronosadminapi.entities.Bank;

public class BankDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String number;
	
	public BankDTO() {

	}

	public BankDTO(Long id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	public BankDTO(Bank entity) {
		id = entity.getId();
		name = entity.getName();
		number = entity.getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
