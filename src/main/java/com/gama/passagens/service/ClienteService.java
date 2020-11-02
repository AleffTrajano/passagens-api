package com.gama.passagens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Telefone;
import com.gama.passagens.model.Usuario;
import com.gama.passagens.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(Cliente cliente) {
		if(cliente.getTelefone()==null) {
			//faz alguma logica
		}
		if(cliente.getTelefone().getNomeContato()==null) {
			cliente.getTelefone().setNomeContato(cliente.getNome().split(" ")[0]);
		}
		
		Telefone telEmergencia=cliente.getTelefoneEmergencia();
		
		if(telEmergencia!=null && telEmergencia.getNomeContato()==null) {
			//exibe mensagem obrigatoria
		}
		
		//if(cliente.getTelefoneEmergencia()!=null) {
			//if(cliente.getTelefoneEmergencia().getNomeContato()==null) {
				//precisa do nome
			//}
		//}
		
		Usuario usuario = cliente.getUsuario();
		
		if(usuario==null) {
			//para cadastrar precisa login e senha
		}
		
		if(usuario.getLogin()==null)
			usuario.setLogin(cliente.getEmail());
		
		if(usuario.getSenha()==null) {
			//precisa informar
		}
			
		
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		repository.save(cliente);
	}
	
	
}
