package com.gama.passagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.service.ClienteService;

@RestController
@RequestMapping("/")
public class AutenticacaoController {
	@Autowired
	private ClienteService service;
	
	@PostMapping("/signin")
	public void save(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
}
