package com.gama.passagens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Telefone;
import com.gama.passagens.model.Usuario;
import com.gama.passagens.service.ClienteService;

@SpringBootApplication
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(ClienteService s) {
        return args -> {
        	Cliente cli = new Cliente();
        	cli.setNome("GLEYSON");
        	cli.setEmail("gleysondev@gmail.com");
        	Usuario user = new Usuario();
        	user.setLogin("user");
        	user.setSenha("user");
        	cli.setUsuario(user);
        	Telefone t = new Telefone();
        	t.setDdd(11);
        	t.setNumero(654654L);
        	cli.setTelefone(t);
        	s.save(cli);
        	
        	System.out.println("SALVOU");
        };
    }
}
