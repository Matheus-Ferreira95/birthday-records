package com.matheusf.birthday.resources.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();
		
	public ValidationError(Integer status, OffsetDateTime timestamp, String mensagem, String path) {
		super(status, timestamp, mensagem, path);		
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String campo, String mensagem) {
		erros.add(new FieldMessage(campo, mensagem));
	}
}
