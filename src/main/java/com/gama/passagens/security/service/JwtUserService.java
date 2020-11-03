package com.gama.passagens.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Usuario;
import com.gama.passagens.repository.ClienteRepository;

@Service(value = "jwtUserService")
public class JwtUserService implements UserDetailsService  {
	@Autowired
	private ClienteRepository repository;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Cliente cliente = repository.findByLogin(login);
		if(cliente == null){
			throw new UsernameNotFoundException("Usuário não existe");
		}
		Usuario user = cliente;
		Set<SimpleGrantedAuthority> roles=getAuthority(user);
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getSenha(), roles);
	}
	private Set<SimpleGrantedAuthority> getAuthority(Usuario user){
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
		
	}
}
