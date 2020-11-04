package com.gama.passagens.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.project.model.cliente.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	Cliente findByLogin(String login);
	
}
