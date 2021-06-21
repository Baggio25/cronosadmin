package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.BankDTO;
import com.baggio.projeto.cronosadminapi.entities.Bank;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface BankServiceImpl extends GenericService<Bank, BankDTO, Long>{

	Page<BankDTO> findByNamePaged(String name, Pageable pageable);
	
}
