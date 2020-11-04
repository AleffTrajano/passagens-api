package com.gama.passagens.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.passagens.project.model.acesso.Usuario;
import com.gama.passagens.project.model.cliente.Cliente;
import com.gama.passagens.project.model.cliente.Telefone;
import com.gama.passagens.project.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(Cliente cliente) {
		if(cliente.getTelefone()==null) {
			//faz alguma logica
			//return;
		}
		if(cliente.getTelefone().getNomeContato()==null) {
			cliente.getTelefone().setNomeContato(cliente.getNome().split(" ")[0]);
		}
		
		Telefone telEmergencia=cliente.getTelefoneEmergencia();
		
		if(telEmergencia!=null && telEmergencia.getNomeContato()==null) {
			//exibe mensagem obrigatoria
			//return;
		}
		
		//if(cliente.getTelefoneEmergencia()!=null) {
			//if(cliente.getTelefoneEmergencia().getNomeContato()==null) {
				//precisa do nome
			//}
		//}
		
		Usuario usuario = cliente;
		
		if(usuario.getLogin()==null)
			usuario.setLogin(cliente.getEmail());
		
		if(usuario.getSenha()==null) {
			//precisa informar
			//return;
		}
			
		
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(repository.findByLogin(cliente.getLogin())==null)
			repository.save(cliente);
	}
	
	
}
