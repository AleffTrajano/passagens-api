package com.gama.passagens.client.amadeus;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.gama.passagens.client.amadeus.model.FlightOffersPrice;

@FeignClient(name = "tickets", url = "http://localhost:8080/tickets/")
public interface TicketClient {
	@PostMapping("/search/offers")
	List<FlightOffersPrice> tickets(Map<String, String> request);
}
