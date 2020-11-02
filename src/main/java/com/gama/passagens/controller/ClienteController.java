package com.gama.passagens.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public Iterable<Cliente> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable(value="id") Integer id) {
		Optional<Cliente> opt = repository.findById(id);
		return opt.get() ;
	}
	
	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		repository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		repository.deleteById(id);
	}
	
	@PutMapping
	public void update(Cliente cliente) {
		repository.save(cliente);
	}
}
