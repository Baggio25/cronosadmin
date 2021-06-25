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

import com.baggio.projeto.cronosadminapi.dto.FinantialAccountDTO;
import com.baggio.projeto.cronosadminapi.entities.Bank;
import com.baggio.projeto.cronosadminapi.entities.FinantialAccount;
import com.baggio.projeto.cronosadminapi.repositories.BankRepository;
import com.baggio.projeto.cronosadminapi.repositories.FinancialAccountRepository;
import com.baggio.projeto.cronosadminapi.services.exceptions.DatabaseException;
import com.baggio.projeto.cronosadminapi.services.exceptions.ResourceNotFoundException;
import com.baggio.projeto.cronosadminapi.services.impl.FinantialAccountServiceImpl;

@Service
public class FinantialAccountService implements FinantialAccountServiceImpl {

	@Autowired
	private FinancialAccountRepository repository;

	@Autowired
	private BankRepository bankRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<FinantialAccountDTO> findAllPaged(Pageable pageable) {
		Page<FinantialAccount> page = repository.findAll(pageable);
		return page.map(account -> new FinantialAccountDTO(account));
	}

	@Override
	@Transactional(readOnly = true)
	public FinantialAccountDTO findById(Long id) {
		Optional<FinantialAccount> obj = repository.findById(id);
		FinantialAccount entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new FinantialAccountDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FinantialAccountDTO> findAll() {
		List<FinantialAccount> list = repository.findAll();
		return list.stream().map(account -> new FinantialAccountDTO(account)).collect(Collectors.toList());
	}
	
	@Override
	public Page<FinantialAccountDTO> findByDescriptionPaged(String description, Pageable pageable) {
		Page<FinantialAccount> list = repository.findByDescriptionPaged(description, pageable);
		return list.map(account -> new FinantialAccountDTO(account));
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
	public FinantialAccountDTO insert(FinantialAccountDTO dto) {
		FinantialAccount account = new FinantialAccount();
		dtoToEntity(account, dto);
		account = repository.save(account);
		return new FinantialAccountDTO(account);
	}

	@Override
	@Transactional
	public FinantialAccountDTO update(Long id, FinantialAccountDTO dto) {
		try {
			FinantialAccount account = repository.getOne(id);
			dtoToEntity(account, dto);
			account = repository.save(account);
			return new FinantialAccountDTO(account);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + e);
		}
	}

	private void dtoToEntity(FinantialAccount account, FinantialAccountDTO dto) {

		account.setDescription(dto.getDescription());
		account.setBalance(dto.getBalance());
		account.setBank(dto.isBank());
		account.setNumber(dto.getNumber());
		account.setDigit(dto.getDigit());
		account.setAgency(dto.getAgency());
		account.setDigitAgency(dto.getDigitAgency());

		if (dto.getBankId() != null) {
			Bank bank = bankRepository.getOne(dto.getBankId());
			account.setBankEntity(bank);
		}

	}
}
