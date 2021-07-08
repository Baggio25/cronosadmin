package com.baggio.projeto.cronosadminapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.baggio.projeto.cronosadminapi.dto.UserGroupDTO;
import com.baggio.projeto.cronosadminapi.services.UserGroupService;

@RestController
@RequestMapping("/groups")
public class UserGroupResource {

	@Autowired
	private UserGroupService service;
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<UserGroupDTO>> findAllPaged(Pageable pageable) {
		Page<UserGroupDTO> page = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping
	public ResponseEntity<List<UserGroupDTO>> findAll() {
		List<UserGroupDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserGroupDTO> findById(@PathVariable Long id) {
		UserGroupDTO groupDTO = service.findById(id);
		return ResponseEntity.ok().body(groupDTO);
	}
	
	@GetMapping(value = "/findByName")
	public ResponseEntity<Page<UserGroupDTO>> findByName(
			@RequestParam(value = "name", defaultValue = "") String name,
			Pageable pageable) {
		Page<UserGroupDTO> page = service.findByNamePaged(name, pageable);
		return ResponseEntity.ok().body(page);
	}

	@PostMapping
	public ResponseEntity<UserGroupDTO> insert(@Valid @RequestBody UserGroupDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserGroupDTO> update(@PathVariable Long id, @Valid @RequestBody UserGroupDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
