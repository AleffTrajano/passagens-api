package com.gama.passagens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.project.model.acesso.Role;
import com.gama.passagens.project.model.gestao.Operador;
import com.gama.passagens.project.service.CadastroService;

@SpringBootApplication
@EnableFeignClients
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(CadastroService s ) {
        return args -> {
        	/*
        	 * TicketClient tc
        	Map<String,String> params = new HashMap<String, String>();
        	params.put("originCode", "NYC");
        	params.put("destinationCode", "PAR");
        	params.put("departureDate", "2020-11-16");
        	params.put("returnDate", "2020-11-28");
        	params.put("adults", "1");
        	List<FlightOffersPrice> resposta = tc.tickets(params);
        	System.out.println(resposta);
        	*/
        	
        	Operador op = new Operador();
        	op.setLogin("admin");
        	op.setSenha("admin");
        	op.setNome("ADMIN");
        	op.addRole(new Role("ADMIN"));
        	op.addRole(new Role("USER"));
        	s.save(op);
        };
    }
}
