package com.baggio.projeto.cronosadminapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baggio.projeto.cronosadminapi.dto.BankDTO;
import com.baggio.projeto.cronosadminapi.services.BankService;

@RestController
@RequestMapping("/banks")
public class BankResource {

	@Autowired
	private BankService service;
	
	@GetMapping
	public ResponseEntity<Page<BankDTO>> findAllPaged(Pageable pageable) {
		Page<BankDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
}
