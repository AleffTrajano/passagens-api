package com.gama.passagens.client.amadeus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightOffersPriceItinerarie {
	@JsonProperty("duration")
	private String duracao;
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
}
