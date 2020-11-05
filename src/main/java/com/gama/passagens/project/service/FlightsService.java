package com.gama.passagens.project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;

@Service
public class FlightsService {
	@Autowired
	private Amadeus amadeus;
	public Object flights(Map<String,String> params) throws Exception{
		Params p = null;
		for(Map.Entry<String, String> entry : params.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(p==null)
		    	p= Params.with(key, value);
		    else
		    	p.and(key, value);
		}
		FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(p);
		return flightOffersSearches[0].getResponse().getBody();
	}
}
