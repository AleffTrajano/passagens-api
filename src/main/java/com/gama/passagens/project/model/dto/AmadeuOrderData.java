package com.gama.passagens.project.model.dto;

public class AmadeuOrderData {
	private String type = "flight-offers-pricing";
	private Object flightOffers;
	private Object travelers;
	public Object getFlightOffers() {
		return flightOffers;
	}
	public void setFlightOffers(Object flightOffers) {
		this.flightOffers = flightOffers;
	}
	public Object getTravelers() {
		return travelers;
	}
	public void setTravelers(Object travelers) {
		this.travelers = travelers;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
}
