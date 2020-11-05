package com.gama.passagens.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.resources.FlightOrder;
import com.gama.passagens.amadeus.flight.FlightSearch;
import com.gama.passagens.amadeus.flight.FlightSearchService;
import com.gama.passagens.amadeus.order.FlightOrderService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightSearchService flightSearchService;
	
	@Autowired
	private FlightOrderService orderService;
	
	@PostMapping("")
	public FlightSearch flights(@RequestBody Map<String,String> params) {
		try {
			return flightSearchService.flights(params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	
	}
	@PostMapping("/order")
	public String order(@RequestBody String order) {
		return orderService.order(order);
	}
}
