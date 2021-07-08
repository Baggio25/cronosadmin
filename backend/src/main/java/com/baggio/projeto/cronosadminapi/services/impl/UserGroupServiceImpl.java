package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.UserGroupDTO;
import com.baggio.projeto.cronosadminapi.entities.UserGroup;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface UserGroupServiceImpl extends GenericService<UserGroup, UserGroupDTO, Long>{

	Page<UserGroupDTO> findByNamePaged(String name, Pageable pageable);
	
}
