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

import com.baggio.projeto.cronosadminapi.dto.BankDTO;
import com.baggio.projeto.cronosadminapi.entities.Bank;
import com.baggio.projeto.cronosadminapi.repositories.BankRepository;
import com.baggio.projeto.cronosadminapi.services.impl.BankServiceImpl;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class BankService implements BankServiceImpl {

	@Autowired
	private BankRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Page<BankDTO> findAllPaged(Pageable pageable) {
		Page<Bank> list = repository.findAll(pageable);
		return list.map(bank -> new BankDTO(bank));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BankDTO> findByNamePaged(String name, Pageable pageable) {
		Page<Bank> list = repository.findByName(name, pageable);
		return list.map(bank -> new BankDTO(bank));
	}
	
	@Override
	@Transactional(readOnly = true)
	public BankDTO findById(Long id) {
		Optional<Bank> obj = repository.findById(id);
		Bank entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new BankDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankDTO> findAll() {
		List<Bank> list = repository.findAll();
		return list.stream().map(bank -> new BankDTO(bank)).collect(Collectors.toList());
	}

	@Override
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
	public BankDTO insert(BankDTO dto) {
		Bank bank = new Bank();
		bank.setName(dto.getName());
		bank.setNumber(dto.getNumber());
		bank = repository.save(bank);
		return new BankDTO(bank);
	}

	@Override
	@Transactional
	public BankDTO update(Long id, BankDTO dto) {
		try {
			Bank bank = repository.getOne(id);
			bank.setName(dto.getName());
			bank.setNumber(dto.getNumber());
			bank = repository.save(bank);
			return new BankDTO(bank);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + e);
		}

	}

	
}
