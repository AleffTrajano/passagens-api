package com.gama.passagens.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.passagens.infra.exceptions.ConflictException;
import com.gama.passagens.project.model.acesso.Usuario;
import com.gama.passagens.project.model.cliente.Cliente;
import com.gama.passagens.project.model.cliente.Telefone;
import com.gama.passagens.project.model.gestao.Operador;
import com.gama.passagens.project.repository.ClienteRepository;
import com.gama.passagens.project.repository.UsuarioRepostiry;

@Service
public class CadastroService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private UsuarioRepostiry userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	private void saveUsuario(Usuario usuario) {
	
		if(usuario.getSenha()==null) {
			//precisa informar
			//return;
		}
			
		
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(userRepository.findByLogin(usuario.getLogin())==null)
			userRepository.save(usuario);
	}
	public void save(Operador operador) {
		saveUsuario(operador);
	}
	public void save(Cliente cliente) {
		if(repository.existsByCpfCnpj(cliente.getCpfCnpj()))
			throw new ConflictException("CPF já registrado: " + cliente.getCpfCnpj());
		
		
		if(cliente.getTelefone()==null) {
			throw new ConflictException("É necessário informar o telefone no cadastro do cliente");
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
		
		
	}
	
	
}
