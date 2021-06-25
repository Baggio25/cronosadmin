package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.FinantialHistoricDTO;
import com.baggio.projeto.cronosadminapi.entities.FinantialHistoric;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface FinantialHistoricServiceImpl extends GenericService<FinantialHistoric, FinantialHistoricDTO, Long>{

	Page<FinantialHistoricDTO> findByDescriptionPaged(String description, Pageable pageable);
	
}
