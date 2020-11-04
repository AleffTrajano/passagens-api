package com.gama.passagens.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gama.passagens.client.model.Endereco;

@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
	@GetMapping("{cep}/json")
	Endereco buscarEndereco(@PathVariable("cep") String cep);
}
