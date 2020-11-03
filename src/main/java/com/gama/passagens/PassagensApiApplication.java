package com.gama.passagens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Telefone;
import com.gama.passagens.model.Usuario;
import com.gama.passagens.model.acesso.Role;
import com.gama.passagens.repository.RoleRepository;
import com.gama.passagens.service.ClienteService;

@SpringBootApplication
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(ClienteService s, RoleRepository r) {
        return args -> {
        	Role rUser = new Role("USER");
        	Role rAdmin = new Role("ADMIN");
        	
        	r.save(rUser);
        	r.save(rAdmin);
        	
        	
        	Cliente cli = new Cliente();
        	cli.setNome("GLEYSON");
        	cli.setEmail("gleysondev@gmail.com");
        	cli.setLogin("user");
        	cli.setSenha("user");
        	Telefone t = new Telefone();
        	t.setDdd(11);
        	t.setNumero(654654L);
        	cli.setTelefone(t);
        	
        	cli.addRole(rUser);
        	
        	s.save(cli);
        	
        	System.out.println("SALVOU");
        };
    }
}
