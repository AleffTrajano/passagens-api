package com.gama.passagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
	
	/*
	@GetMapping
	public Iterable<Cliente> listar() {
		return repository.findAll();
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		repository.deleteById(id);
	}
	
	
	@PutMapping
	public void update(Cliente cliente) {
		repository.save(cliente);
	}
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable(value="id") Integer id) {
		Optional<Cliente> opt = repository.findById(id);
		return opt.get() ;
	}
	*/
	
	
	
}
