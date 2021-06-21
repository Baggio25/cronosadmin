package com.baggio.projeto.cronosadminapi.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.baggio.projeto.cronosadminapi.dto.BankDTO;
import com.baggio.projeto.cronosadminapi.entities.Bank;
import com.baggio.projeto.cronosadminapi.repositories.BankRepository;
import com.baggio.projeto.cronosadminapi.resources.exceptions.FieldMessage;

public class BankValidator implements ConstraintValidator<BankValid, BankDTO>{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private BankRepository repository;
	
	@Override
	public boolean isValid(BankDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long bankId = 0;
		
		if(!uriVars.isEmpty()) {
			bankId = Long.parseLong(uriVars.get("id"));
		}
		
		Bank bankByName = repository.findByNameEquals(dto.getName());
		Bank bankByNumber = repository.findByNumberEquals(dto.getNumber());
		
		if((bankByName != null) || (bankByName != null && bankId != bankByName.getId())) {
			list.add(new FieldMessage("name", "Nome já está sendo utilizado."));
		}
		
		if(bankByNumber != null  || (bankByNumber != null && bankId != bankByNumber.getId())) {
			list.add(new FieldMessage("number", "Número já está sendo utilizado."));
		}		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
		
		
	}

}
