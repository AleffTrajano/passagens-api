package com.gama.passagens.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Traveler;
import com.gama.passagens.project.model.dto.AmadeuOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class VooService {
	@Autowired
	private Amadeus amadeus;
	public Object consultaVoos(Map<String,String> params) throws Exception{
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
		//return Arrays.asList(flightOffersSearches);
	}
	public void gerarPedido(AmadeuOrder orderObjetct) throws Exception{
		
		/*
		 * JsonArray flighOffers = new
		 * Gson().toJsonTree(orderObjetct.getData().getFlightOffers()).getAsJsonArray();
		 * JsonObject offers = new JsonObject(); offers.add("flight-offer",
		 * flighOffers);
		 * 
		 */
		
		List<Object> l = (List<Object>) orderObjetct.getData().getFlightOffers();
		
		JsonArray flighOffers = new Gson().toJsonTree(l).getAsJsonArray();
		JsonObject offers = new JsonObject(); 
		offers.add("flightOffers",
		flighOffers);
				 
		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//String jsons = gson.toJson(orderObjetct.getData().getFlightOffers());
		
		//FlightOfferSearch s= gson.toJson(jsons, FlightOfferSearch.class) ;
		
		FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(offers);

	    // We book the flight previously priced
	    FlightOrder order = amadeus.booking.flightOrders.post(flightPricing, (Traveler[]) orderObjetct.getData().getTravelers());
	    System.out.println(order.getResponse());

	    // Return CO2 Emission of the previously booked flight
	    int weight = order.getFlightOffers()[0].getItineraries(
	    )[0].getSegments()[0].getCo2Emissions()[0].getWeight();
	    String unit = order.getFlightOffers()[0].getItineraries(
	    )[0].getSegments()[0].getCo2Emissions()[0].getWeightUnit();


		System.out.println();
		
	}
	/*
	params.put("originCode", "NYC");
	params.put("destinationCode", "PAR");
	params.put("departureDate", "2020-11-16");
	params.put("returnDate", "2020-11-28");
	params.put("adults", "1");
	*/
}
