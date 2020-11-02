package com.gama.passagens.model;

import javax.persistence.Column;

public class Telefone {
	@Column(length = 3)
	private Integer ddd;
	
	@Column(length = 12)
	private Long numero;
	
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
}
