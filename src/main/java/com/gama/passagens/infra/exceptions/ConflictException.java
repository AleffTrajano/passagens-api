package com.gama.passagens.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public ConflictException(String reason) {
		super(HttpStatus.CONFLICT, reason);
	}

}

