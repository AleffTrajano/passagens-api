package com.gama.passagens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.client.ViaCepClient;
import com.gama.passagens.client.model.Endereco;
import com.gama.passagens.model.acesso.Role;
import com.gama.passagens.model.cliente.Cliente;
import com.gama.passagens.model.cliente.Telefone;
import com.gama.passagens.model.gestao.Operador;
import com.gama.passagens.repository.OperadorRepository;
import com.gama.passagens.repository.RoleRepository;
import com.gama.passagens.service.ClienteService;

@SpringBootApplication
@EnableFeignClients
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(ClienteService s,RoleRepository r, OperadorRepository or, ViaCepClient cep	 ) {
        return args -> {
        	
        	Endereco buscarEndereco = cep.buscarEndereco("51290605");
        	
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
        	
        	
        	Operador ope = new Operador();
        	ope.setNome("GESTOR");
        	ope.setLogin("admin");
        	ope.setSenha("admin");
        	
        	
        	ope.addRole(rAdmin);
        	ope.addRole(rUser);
        	
        	if(or.findByLogin(ope.getLogin())==null)
        		or.save(ope);
        	
        	System.out.println("SALVOU");
        };
    }
}
