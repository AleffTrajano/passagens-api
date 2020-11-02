package com.gama.passagens.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Usuario {
	@Column(length = 70)
	private String login;
	
	@Column(length = 100)
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
