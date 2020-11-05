package com.gama.passagens.amadeus.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

@Service
public class FlightOrderService {
	@Autowired
	private Amadeus amadeus;
	//se quiser ler de arquivo
	/*
	public static void gerarOrder() throws Exception {
		String content = new String(Files.readAllBytes(Paths.get("/dev/json.json")));
		FlightOrderRequest root = converter(content);
		order(root);
	}
	*/
	private FlightOrderRequest converter(String json) throws Exception {
		Gson gson = new Gson();
		FlightOrderRequest root = gson.fromJson(json, FlightOrderRequest.class);
		return root;
	}
	private FlightOrderRequest converter(Map json) throws Exception {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(json);
		FlightOrderRequest req = gson.fromJson(jsonElement, FlightOrderRequest.class);
		return req;
	}
	public String postOrder(String json) throws RuntimeException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String response = null;
		FlightOrder order = null;
		try {
			order = amadeus.booking.flightOrders.post(json);
			if (order == null)
				throw new RuntimeException("A passagem solicitada não existe.");
			
			if (order.getResponse().getStatusCode() != 200 && order.getResponse().getStatusCode() != 201)
				throw new RuntimeException("" + order.getResponse().getStatusCode());

		} catch (ResponseException e) {
			throw new RuntimeException(e.getMessage().replaceAll("\n", " - "));
		}
		response = gson.toJson(order.getResponse().getResult());
		return response;
	}
	public String getOrder(String id) throws RuntimeException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String response = null;
		try {
			//com.amadeus.booking.FlightOrder fo = new com.amadeus.booking.FlightOrder(amadeus,id);
			//FlightOrder order = fo.get();
			
			FlightOrder order = amadeus.booking.flightOrder(id).get();
			
			if (order == null)
				throw new RuntimeException("A passagem solicitada não existe.");
			
			if (order.getResponse().getStatusCode() != 200 && order.getResponse().getStatusCode() != 201)
				throw new RuntimeException("" + order.getResponse().getStatusCode());
			
			response = gson.toJson(order.getResponse().getResult());
		} catch (ResponseException e) {
			throw new RuntimeException(e.getMessage().replaceAll("\n", " - "));
		}
		
		return response;
	}
	
}
