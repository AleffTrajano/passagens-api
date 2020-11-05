package com.gama.passagens.project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.gama.passagens.infra.exceptions.BusinessException;

@Service
public class VooService {
	@Autowired
	private Amadeus amadeus;
	public Object consultaVoos(Map<String,String> params){
		if(params==null || params.size()==0)
			throw new BusinessException("Por favor informe ao menos um parametro");
		
		Params p = null;
		for(Map.Entry<String, String> entry : params.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(p==null)
		    	p= Params.with(key, value);
		    else
		    	p.and(key, value);
		}
		FlightOfferSearch[] flightOffersSearches=null;
		try {
			flightOffersSearches = amadeus.shopping.flightOffersSearch.get(p);
		}catch (Exception e) {
			throw new BusinessException("Erro ao tentar consultar a API do Amadeus");
		}
		
		return flightOffersSearches[0].getResponse().getBody();
		
		//return Arrays.asList(flightOffersSearches);
	}
	
}
