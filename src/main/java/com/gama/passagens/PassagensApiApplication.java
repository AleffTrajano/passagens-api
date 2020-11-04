package com.gama.passagens;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.gama.passagens.client.amadeus.TicketClient;
import com.gama.passagens.client.amadeus.model.FlightOffersPrice;

@SpringBootApplication
@EnableFeignClients
public class PassagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagensApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(TicketClient tc) {
        return args -> {
        	Map<String,String> params = new HashMap<String, String>();
        	params.put("originCode", "NYC");
        	params.put("destinationCode", "PAR");
        	params.put("departureDate", "2020-11-16");
        	params.put("returnDate", "2020-11-28");
        	params.put("adults", "1");
        	
        	
        	List<FlightOffersPrice> resposta = tc.tickets(params);
        	System.out.println(resposta);
        };
    }
}
