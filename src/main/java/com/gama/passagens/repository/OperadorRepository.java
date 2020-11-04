package com.gama.passagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.passagens.model.cliente.Cliente;
import com.gama.passagens.model.gestao.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Integer> {
	Operador findByLogin(String login);
}
