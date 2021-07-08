package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baggio.projeto.cronosadminapi.entities.User;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Favor informar um e-mail válido")
	private String email;
	private boolean active;
	
	@NotNull(message = "Campo obrigatório")
	private Long userGroupId;

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, boolean active, Long userGroupId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.active = active;
		this.userGroupId = userGroupId;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		active = entity.isActive();
		userGroupId = entity.getUserGroup().getId();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}
	
}
