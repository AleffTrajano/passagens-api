package com.gama.passagens.model.dto;

public class Credencial {
	private String login;
	private String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getLogin() {
		return login;
	}
    public void setLogin(String login) {
		this.login = login;
	}
    
}