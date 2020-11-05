package com.gama.passagens.clientapi.amadeus;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;

import com.gama.passagens.clientapi.amadeus.model.FlightOffersPrice;

//@FeignClient(name = "tickets", url = "http://localhost:8080/tickets/")
public interface TicketClient {
	@PostMapping("/search/offers")
	List<FlightOffersPrice> tickets(Map<String, String> request);
}
