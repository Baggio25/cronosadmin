package com.baggio.projeto.cronosadminapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.baggio.projeto.cronosadminapi.dto.FinantialAccountDTO;
import com.baggio.projeto.cronosadminapi.resources.exceptions.FieldMessage;

public class FinantialAccountValidator implements ConstraintValidator<FinantialAccountValid, FinantialAccountDTO> {

	@Override
	public boolean isValid(FinantialAccountDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		if (dto.isBank() == true) {

			if (dto.getNumber().isBlank()) {
				list.add(new FieldMessage("number", "Número é obrigatório"));
			}

			if (dto.getNumber().isBlank()) {
				list.add(new FieldMessage("digit", "Dígito é obrigatório"));
			}

			if (dto.getNumber().isBlank()) {
				list.add(new FieldMessage("agency", "Agência é obrigatória"));
			}

			if (dto.getNumber().isBlank()) {
				list.add(new FieldMessage("digitAgency", "Digito da agência é obrigatória"));
			}

			if (dto.getBankId() == null) {
				list.add(new FieldMessage("bankId", "Banco é obrigatório"));
			}

		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();

	}

}
