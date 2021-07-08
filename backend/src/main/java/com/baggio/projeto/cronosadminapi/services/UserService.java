package com.baggio.projeto.cronosadminapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baggio.projeto.cronosadminapi.dto.UserDTO;
import com.baggio.projeto.cronosadminapi.dto.UserInsertDTO;
import com.baggio.projeto.cronosadminapi.dto.UserUpdateDTO;
import com.baggio.projeto.cronosadminapi.entities.User;
import com.baggio.projeto.cronosadminapi.entities.UserGroup;
import com.baggio.projeto.cronosadminapi.repositories.UserGroupRepository;
import com.baggio.projeto.cronosadminapi.repositories.UserRepository;
import com.baggio.projeto.cronosadminapi.services.exceptions.DatabaseException;
import com.baggio.projeto.cronosadminapi.services.exceptions.ResourceNotFoundException;
import com.baggio.projeto.cronosadminapi.services.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserGroupRepository groupRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		return page.map(user -> new UserDTO(user));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UserDTO> findByNamePaged(String name, Pageable pageable) {
		Page<User> page = repository.findByName(name, pageable);
		return page.map(user -> new UserDTO(user));
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
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

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User user = new User();
		dtoToEntity(dto, user);
		user.setPassword(dto.getPassword()); // Fazer a criptografia
		
		user = repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		User user = repository.getOne(id);
		dtoToEntity(dto, user);

		user = repository.save(user);
		return new UserDTO(user);
	}

	private void dtoToEntity(UserDTO dto, User user) {
		UserGroup group = groupRepository.getOne(dto.getUserGroupId());
		
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setActive(dto.isActive());
		user.setUserGroup(group);
	}

	/***
	 * No used
	 */
	@Override
	public UserDTO insert(UserDTO dto) {
		return null;
	}

	/***
	 * No used
	 */
	@Override
	public UserDTO update(Long id, UserDTO dto) {
		return null;
	}

	

}
