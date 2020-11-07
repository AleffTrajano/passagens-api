package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accenture.gama.viajei.model.pagamento.PagarmeService;
import com.gama.passagens.project.start.Start;

import me.pagar.model.Transaction;

@SpringBootApplication
//@EnableFeignClients
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run( Start st, PagarmeService ps) {
        return args -> {
        	st.init();
        	Transaction transaction= ps.criarTransacao();
        	System.out.println(transaction.getStatus());
        };
    }
}
