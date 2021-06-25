package com.baggio.projeto.cronosadminapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baggio.projeto.cronosadminapi.dto.FinantialHistoricDTO;
import com.baggio.projeto.cronosadminapi.entities.FinantialAccount;
import com.baggio.projeto.cronosadminapi.entities.FinantialHistoric;
import com.baggio.projeto.cronosadminapi.repositories.FinantialAccountRepository;
import com.baggio.projeto.cronosadminapi.repositories.FinantialHistoricRepository;
import com.baggio.projeto.cronosadminapi.services.exceptions.DatabaseException;
import com.baggio.projeto.cronosadminapi.services.exceptions.ResourceNotFoundException;
import com.baggio.projeto.cronosadminapi.services.impl.FinantialHistoricServiceImpl;

@Service
public class FinantialHistoricService implements FinantialHistoricServiceImpl {

	@Autowired
	private FinantialHistoricRepository repository;

	@Autowired
	private FinantialAccountRepository accountRepository;


	@Override
	@Transactional(readOnly = true)
	public Page<FinantialHistoricDTO> findAllPaged(Pageable pageable) {
		Page<FinantialHistoric> page = repository.findAll(pageable);
		return page.map(historic -> new FinantialHistoricDTO(historic));
	}

	@Override
	@Transactional(readOnly = true)
	public FinantialHistoricDTO findById(Long id) {
		Optional<FinantialHistoric> obj = repository.findById(id);
		FinantialHistoric entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new FinantialHistoricDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FinantialHistoricDTO> findAll() {
		List<FinantialHistoric> list = repository.findAll();
		return list.stream().map(historic -> new FinantialHistoricDTO(historic)).collect(Collectors.toList());
	}
	
	@Override
	public Page<FinantialHistoricDTO> findByDescriptionPaged(String description, Pageable pageable) {
		Page<FinantialHistoric> list = repository.findByDescriptionPaged(description, pageable);
		return list.map(historic -> new FinantialHistoricDTO(historic));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	@Override
	@Transactional
	public FinantialHistoricDTO insert(FinantialHistoricDTO dto) {
		FinantialHistoric historic = new FinantialHistoric();
		dtoToEntity(historic, dto);
		historic = repository.save(historic);
		return new FinantialHistoricDTO(historic);
	}

	@Override
	@Transactional
	public FinantialHistoricDTO update(Long id, FinantialHistoricDTO dto) {
		try {
			FinantialHistoric historic = repository.getOne(id);
			dtoToEntity(historic, dto);
			historic = repository.save(historic);
			return new FinantialHistoricDTO(historic);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + e);
		}
	}

	private void dtoToEntity(FinantialHistoric historic, FinantialHistoricDTO dto) {
		FinantialAccount account = accountRepository.getOne(dto.getAccountId());
		
		historic.setDescription(dto.getDescription());
		historic.setOperation(dto.getOperation());
		historic.setActive(dto.isActive());
		historic.setAccount(account);
	}
}
