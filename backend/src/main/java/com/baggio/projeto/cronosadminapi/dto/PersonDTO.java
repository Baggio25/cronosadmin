package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.baggio.projeto.cronosadminapi.entities.FinantialMovement;
import com.baggio.projeto.cronosadminapi.entities.Person;

public class PersonDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	private String cpfCnpj; //Falta validar o CPF / CNPJ existente e se é válido
	private String telephone;
	private String celular;
	private boolean active;
	
	private List<FinantialMovementDTO> movements = new ArrayList<FinantialMovementDTO>();
	
	public PersonDTO() {
	}

	public PersonDTO(Long id, String name, String cpfCnpj, String telephone, String celular, boolean active) {
		this.id = id;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.telephone = telephone;
		this.celular = celular;
		this.active = active;
	}

	public PersonDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		cpfCnpj = entity.getCpfCnpj();
		telephone = entity.getTelephone();
		celular = entity.getCelular();
		active = entity.isActive();
	}
	
	public PersonDTO(Person entity, Set<FinantialMovement> movements) {
		this(entity);
		entity.getMovements().forEach(movement -> this.movements.add(new FinantialMovementDTO(movement)));
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<FinantialMovementDTO> getMovements() {
		return movements;
	}
	
}
