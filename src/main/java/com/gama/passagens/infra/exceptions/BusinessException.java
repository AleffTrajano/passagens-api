package com.gama.passagens.infra.exceptions;

import com.gama.passagens.infra.exceptions.config.ErrorType;

public  class BusinessException extends RuntimeException {
	private String tipo;
	private String codigo;
	private String mensagem;
	
	public BusinessException(ErrorType error, Object... args) {
		super(String.format(error.getMensagem(), args));
		this.tipo=error.getTipo();
		this.codigo=error.getCodigo();
		this.mensagem=String.format(error.getMensagem(), args);
	}

	public BusinessException(String mensagem) {
		super(mensagem);
		 ErrorType erroGenerico = ErrorType.ERRO_GENERICO;
		this.tipo=erroGenerico.getTipo();
		this.codigo=erroGenerico.getCodigo();
		this.mensagem=mensagem;
	}
	
	public static BusinessException erroGenerico() {
		return new BusinessException(ErrorType.ERRO_GENERICO);
	}
	public String getTipo() {
		return tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
}
