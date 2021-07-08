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

import com.baggio.projeto.cronosadminapi.dto.RoleDTO;
import com.baggio.projeto.cronosadminapi.dto.UserGroupDTO;
import com.baggio.projeto.cronosadminapi.entities.Role;
import com.baggio.projeto.cronosadminapi.entities.UserGroup;
import com.baggio.projeto.cronosadminapi.repositories.RoleRepository;
import com.baggio.projeto.cronosadminapi.repositories.UserGroupRepository;
import com.baggio.projeto.cronosadminapi.services.exceptions.DatabaseException;
import com.baggio.projeto.cronosadminapi.services.exceptions.ResourceNotFoundException;
import com.baggio.projeto.cronosadminapi.services.impl.UserGroupServiceImpl;

@Service
public class UserGroupService implements UserGroupServiceImpl {

	@Autowired
	private UserGroupRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<UserGroupDTO> findAllPaged(Pageable pageable) {
		Page<UserGroup> page = repository.findAll(pageable);
		return page.map(group -> new UserGroupDTO(group));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UserGroupDTO> findByNamePaged(String name, Pageable pageable) {
		Page<UserGroup> page = repository.findByName(name, pageable);
		return page.map(group -> new UserGroupDTO(group));
	}

	@Override
	@Transactional(readOnly = true)
	public UserGroupDTO findById(Long id) {
		Optional<UserGroup> obj = repository.findById(id);
		UserGroup entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserGroupDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroupDTO> findAll() {
		List<UserGroup> list = repository.findAll();
		return list.stream().map(group -> new UserGroupDTO(group)).collect(Collectors.toList());
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
	public UserGroupDTO insert(UserGroupDTO dto) {
		UserGroup group = new UserGroup();
		dtoToEntity(dto, group);

		group = repository.save(group);
		return new UserGroupDTO(group);
	}

	@Override
	@Transactional
	public UserGroupDTO update(Long id, UserGroupDTO dto) {
		UserGroup group = repository.getOne(id);
		dtoToEntity(dto, group);

		group = repository.save(group);
		return new UserGroupDTO(group);
	}

	private void dtoToEntity(UserGroupDTO dto, UserGroup group) {
		group.setName(dto.getName());
		group.setActive(dto.isActive());

		group.getRoles().clear();
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDTO.getId());
			group.getRoles().add(role);
		}
	}

}
