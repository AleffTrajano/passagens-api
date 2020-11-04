package com.gama.passagens.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.project.model.cliente.Cliente;
import com.gama.passagens.project.model.enums.Roles;
import com.gama.passagens.project.repository.ClienteRepository;

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
	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		repository.save(cliente);
	}

}
