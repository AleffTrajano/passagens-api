package com.gama.passagens.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.amadeus.flight.FlightSearch;
import com.gama.passagens.amadeus.flight.FlightSearchService;
import com.gama.passagens.amadeus.order.FlightOrderService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	//@Autowired
	//private FlightsService service;
	
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
	public void order(@RequestBody Map order) {
		try {
			orderService.order(order);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    	
	}
}
