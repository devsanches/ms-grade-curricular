package br.com.devsanches.cliente.escola.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MateriaException extends RuntimeException {

	private static final long serialVersionUID = -4870390870916489260L;
	
	private final HttpStatus httpStatus;
	
	public MateriaException(final String mensagem, final HttpStatus httpStatus) {
		super(mensagem);
		this.httpStatus = httpStatus;
	}
	
}
