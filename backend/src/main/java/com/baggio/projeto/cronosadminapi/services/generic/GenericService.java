package com.baggio.projeto.cronosadminapi.services.generic;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, DTO, InsertDTO, UpdateDTO, ID> {

	
	Page<DTO> findAllPaged(Pageable pageable); 
	
	DTO findById(ID id); 

	List<DTO> findAll();
	
	void delete(ID id);
	
	DTO insert(InsertDTO dto);

	DTO update(Long id, UpdateDTO dto);
	
}
