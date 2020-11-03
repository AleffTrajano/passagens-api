package com.gama.passagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Integer> {
	Operador findByLogin(String login);
}
