package com.baggio.projeto.cronosadminapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baggio.projeto.cronosadminapi.entities.enums.Operation;

@Entity
@Table(name = "tb_financial_historic")
public class FinantialHistoric implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Operation operation;
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "financial_account_id")
	private FinantialAccount account;
	
	public FinantialHistoric() {

	}

	public FinantialHistoric(Long id, String description, Operation operation, boolean active,
			FinantialAccount account) {
		this.id = id;
		this.description = description;
		this.operation = operation;
		this.active = active;
		this.account = account;
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

	public FinantialAccount getAccount() {
		return account;
	}

	public void setAccount(FinantialAccount account) {
		this.account = account;
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
		FinantialHistoric other = (FinantialHistoric) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
