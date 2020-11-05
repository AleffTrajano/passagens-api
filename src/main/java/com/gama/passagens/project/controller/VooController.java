package com.gama.passagens.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.clientapi.amadeus.TicketClient;
import com.gama.passagens.clientapi.amadeus.model.FlightOffersPrice;

//@RestController
//@RequestMapping("/voos")
public class VooController {
	//@Autowired
	private TicketClient tc;
	//@GetMapping
	public List<FlightOffersPrice>  voos() {
		Map<String,String> params = new HashMap<String, String>();
    	params.put("originCode", "NYC");
    	params.put("destinationCode", "PAR");
    	params.put("departureDate", "2020-11-16");
    	params.put("returnDate", "2020-11-28");
    	params.put("adults", "1");
    	List<FlightOffersPrice> resposta = tc.tickets(params);
    	return resposta;
    	
	}
}
