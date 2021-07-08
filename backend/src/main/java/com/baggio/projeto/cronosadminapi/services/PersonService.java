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

import com.baggio.projeto.cronosadminapi.dto.PersonDTO;
import com.baggio.projeto.cronosadminapi.entities.Person;
import com.baggio.projeto.cronosadminapi.repositories.PersonRepository;
import com.baggio.projeto.cronosadminapi.services.exceptions.DatabaseException;
import com.baggio.projeto.cronosadminapi.services.exceptions.ResourceNotFoundException;
import com.baggio.projeto.cronosadminapi.services.impl.PersonServiceImpl;

@Service
public class PersonService implements PersonServiceImpl {

	@Autowired
	private PersonRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Page<PersonDTO> findAllPaged(Pageable pageable) {
		Page<Person> page = repository.findAll(pageable);
		return page.map(person -> new PersonDTO(person));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PersonDTO> findByNamePaged(String name, Pageable pageable) {
		Page<Person> list = repository.findByName(name, pageable);
		return list.map(person -> new PersonDTO(person));
	}
	
	@Override
	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		Person entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PersonDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll() {
		List<Person> list = repository.findAll();
		return list.stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
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
	public PersonDTO insert(PersonDTO dto) {
		Person person = new Person();
		dtoToEntity(dto, person);

		person = repository.save(person);
		return new PersonDTO(person);
	}

	
	@Override
	@Transactional
	public PersonDTO update(Long id, PersonDTO dto) {
		try {
			Person person = repository.getOne(id);
			dtoToEntity(dto, person);
			
			person = repository.save(person);
			return new PersonDTO(person);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + e);
		}

	}

	
	private void dtoToEntity(PersonDTO dto, Person person) {
		person.setName(dto.getName());
		person.setCpfCnpj(dto.getCpfCnpj());
		person.setTelephone(dto.getTelephone());
		person.setCelular(dto.getCelular());
		person.setActive(dto.isActive());
	}

	
}
