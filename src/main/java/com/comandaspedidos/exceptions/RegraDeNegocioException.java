package com.comandaspedidos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraDeNegocioException extends RuntimeException{

	
	
	public RegraDeNegocioException(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = 1L;

}
