package com.gama.passagens.project.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.passagens.infra.exceptions.BusinessException;
import com.gama.passagens.project.model.acesso.Role;
import com.gama.passagens.project.model.acesso.Usuario;
import com.gama.passagens.project.model.cadastro.Viajante;
import com.gama.passagens.project.model.gestao.Operador;
import com.gama.passagens.project.repository.UsuarioRepostiry;
import com.gama.passagens.project.repository.ViajanteRepository;

@Service
public class CadastroService {
	
	@Autowired
	private ViajanteRepository repository;
	
	@Autowired
	private UsuarioRepostiry userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	private void saveUsuario(Usuario usuario) {
	
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(userRepository.findByLogin(usuario.getLogin())==null)
			userRepository.save(usuario);
		
	}
	public void save(Operador operador) {
		saveUsuario(operador);
	}
	
	public void save(Viajante cliente) {
		if(cliente.getId()==null) {
			cliente.setRoles(new HashSet<>());
			cliente.addRole(new Role("USER"));
		}
		
		
	}
	
	
}
