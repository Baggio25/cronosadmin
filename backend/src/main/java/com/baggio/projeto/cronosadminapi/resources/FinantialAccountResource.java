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

import com.baggio.projeto.cronosadminapi.dto.FinantialAccountDTO;
import com.baggio.projeto.cronosadminapi.services.FinantialAccountService;

@RestController
@RequestMapping("/accounts")
public class FinantialAccountResource {

	@Autowired
	private FinantialAccountService service;
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<FinantialAccountDTO>> findAllPaged(Pageable pageable) {
		Page<FinantialAccountDTO> page = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping
	public ResponseEntity<List<FinantialAccountDTO>> findAll() {
		List<FinantialAccountDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FinantialAccountDTO> findById(@PathVariable Long id) {
		FinantialAccountDTO accountDTO = service.findById(id);
		return ResponseEntity.ok().body(accountDTO);
	}
	
	@GetMapping(value = "/findByDescription")
	public ResponseEntity<Page<FinantialAccountDTO>> findByDescriptionPaged(
			@RequestParam(value = "description", defaultValue = "") String description,
			Pageable pageable) {
		Page<FinantialAccountDTO> page = service.findByDescriptionPaged(description, pageable);
		return ResponseEntity.ok().body(page);
	}

	@PostMapping
	public ResponseEntity<FinantialAccountDTO> insert(@Valid @RequestBody FinantialAccountDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FinantialAccountDTO> update(@PathVariable Long id, @Valid @RequestBody FinantialAccountDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
