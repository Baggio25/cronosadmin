package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.FinantialAccountDTO;
import com.baggio.projeto.cronosadminapi.entities.FinantialAccount;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface FinantialAccountServiceImpl extends GenericService<FinantialAccount, FinantialAccountDTO, Long>{

	Page<FinantialAccountDTO> findByDescriptionPaged(String description, Pageable pageable);
	
}
