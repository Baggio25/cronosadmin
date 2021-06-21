package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.baggio.projeto.cronosadminapi.entities.Bank;
import com.baggio.projeto.cronosadminapi.services.validation.BankValid;

@BankValid
public class BankDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@Size(min = 3, max = 3, message = "Deve ter 3 caracteres. Ex.: 001, 123")
	@NotBlank(message = "Campo obrigatório")
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
