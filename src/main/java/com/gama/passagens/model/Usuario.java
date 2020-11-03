package com.gama.passagens.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.gama.passagens.model.acesso.Role;

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
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "login",nullable=false), inverseJoinColumns = @JoinColumn(name = "role",nullable=false))
	private Set<Role> roles = new HashSet<>();
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}
	public Set<Role> getRoles() {
		return roles;
	}
	
	
}
