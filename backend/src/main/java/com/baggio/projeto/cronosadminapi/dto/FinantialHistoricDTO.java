package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baggio.projeto.cronosadminapi.entities.FinantialHistoric;
import com.baggio.projeto.cronosadminapi.entities.enums.Operation;

public class FinantialHistoricDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@NotNull(message = "Campo obrigatório")
	private Operation operation;
	
	private boolean active;
	
	@NotNull(message = "Campo obrigatório")
	private Long accountId;
	
	public FinantialHistoricDTO() {

	}

	public FinantialHistoricDTO(Long id, String description, Operation operation, boolean active, Long accountId) {
		this.id = id;
		this.description = description;
		this.operation = operation;
		this.active = active;
		this.accountId = accountId;
	}
	
	public FinantialHistoricDTO(FinantialHistoric entity) {
		id = entity.getId();
		description = entity.getDescription();
		operation = entity.getOperation();
		active = entity.isActive();
		accountId = entity.getAccount().getId();
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

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
}
