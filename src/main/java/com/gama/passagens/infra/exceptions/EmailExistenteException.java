package com.gama.passagens.infra.exceptions;

import com.gama.passagens.infra.exceptions.config.ErrorType;

public class EmailExistenteException extends BusinessException {

	public EmailExistenteException(Object ... args) {
		super(ErrorType.EMAIL_EXISTENTE, args);
	}	
}
