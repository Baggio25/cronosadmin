package com.baggio.projeto.cronosadminapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baggio.projeto.cronosadminapi.dto.PersonDTO;
import com.baggio.projeto.cronosadminapi.entities.Person;
import com.baggio.projeto.cronosadminapi.services.generic.GenericService;

public interface PersonServiceImpl extends GenericService<Person, PersonDTO, Long>{

	Page<PersonDTO> findByNamePaged(String name, Pageable pageable);
	
}
