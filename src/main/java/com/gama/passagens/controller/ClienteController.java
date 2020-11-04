package com.gama.passagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.model.cliente.Cliente;
import com.gama.passagens.model.enums.Roles;
import com.gama.passagens.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	@PreAuthorize(Roles.PRE_ADMIN)
	public Iterable<Cliente> listar() {
		return repository.findAll();
	}

}
