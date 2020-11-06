package com.gama.passagens.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.passagens.amadeus.order.FlightOrderService;
import com.gama.passagens.amadeus.order.Order;
import com.gama.passagens.project.model.reserva.Reserva;
import com.gama.passagens.project.repository.ReservaRepository;

@Component
public class OrderService {
	@Autowired
	private FlightOrderService orderService;
	
	@Autowired
	private ReservaRepository repository;
	
	public String createOrder(Integer viajanteId, String json) {
		Order postOrder = orderService.postOrder(json);
		
		if(postOrder.getId()!=null) {
			Reserva r = new Reserva();
			r.setOrderId(postOrder.getId());
			r.setPrice(postOrder.getPrice());
			r.setViajanteId(viajanteId);
			repository.save(r);
		}
		
		
		return postOrder.getJson();
	}
}
