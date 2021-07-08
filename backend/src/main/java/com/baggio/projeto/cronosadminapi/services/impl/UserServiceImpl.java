package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.UserDTO;
import com.baggio.projeto.cronosadminapi.entities.User;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface UserServiceImpl extends GenericService<User, UserDTO, Long>{

	Page<UserDTO> findByNamePaged(String name, Pageable pageable);
	//Page<UserDTO> findByEmailPaged(String name, Pageable pageable);
	
}
