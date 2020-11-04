package com.gama.passagens.client.amadeus.model;

import java.util.List;

public class FlightOffersPrice {
	private Integer id;
	private String source;
	private List<FlightOffersPriceItinerarie> itineraries;

	public List<FlightOffersPriceItinerarie> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<FlightOffersPriceItinerarie> itineraries) {
		this.itineraries = itineraries;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
