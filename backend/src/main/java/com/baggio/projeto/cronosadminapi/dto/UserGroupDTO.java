package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.baggio.projeto.cronosadminapi.entities.UserGroup;

public class UserGroupDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	private boolean active;
	
	private Set<RoleDTO> roles = new HashSet<>();

	public UserGroupDTO() {
	}
	
	public UserGroupDTO(Long id, String name, boolean active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}

	public UserGroupDTO(UserGroup entity) {
		id = entity.getId();
		name = entity.getName();
		active = entity.isActive();
		
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
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
		UserGroupDTO other = (UserGroupDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
