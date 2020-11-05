package com.gama.passagens.amadeus.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Traveler;
import com.amadeus.resources.Traveler.Phone;
import com.google.gson.Gson;
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
	
	public void order(Map orderRequest) throws Exception {
		
		FlightOrderRequest request = converter(orderRequest);
		

	    Traveler[] travelerArray = new Traveler[1];
	    travelerArray[0] = request.getData().getTravelers().get(0);
	    System.out.println(travelerArray[0]);
	    
	    
	 // We price the 2nd flight of the list to confirm the price and the availability
	    FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(request.getData().getFlightOffers().get(0));

	    // We book the flight previously priced
	    FlightOrder order = amadeus.booking.flightOrders.post(flightPricing, travelerArray);
	    System.out.println(order.getResponse());

	    // Return CO2 Emission of the previously booked flight
	    int weight = order.getFlightOffers()[0].getItineraries(
	    )[0].getSegments()[0].getCo2Emissions()[0].getWeight();
	    String unit = order.getFlightOffers()[0].getItineraries(
	    )[0].getSegments()[0].getCo2Emissions()[0].getWeightUnit();


		System.out.println();
	}
	
	private static void traveller() {
		Viajante traveler = new Viajante();

	    traveler.setId("1");
	    traveler.setDateOfBirth("1982-01-16");
	    traveler.setName(traveler.new Name("JORGE", "GONZALES"));
	    
	    Traveler.Phone[] phone = new Phone[1];
	    phone[0] = traveler.new Phone();
	    phone[0].setCountryCallingCode("34");
	    phone[0].setNumber("480080076");
	    phone[0].setDeviceType("MOBILE");

	    Viajante.Contato contact = traveler.new Contato();
	    contact.setEmailAddress("jorge.gonzales833@telefonica.es");
	    contact.setPhones(phone);
	    
	    traveler.setContact(contact);

	    Viajante.Documento[] document = new Viajante.Documento[1];
	    document[0] = traveler.new Documento();
	    document[0].setDocumentType("PASSPORT");
	    document[0].setBirthPlace("Madrid");
	    document[0].setIssuanceLocation("Madrid");
	    document[0].setIssuanceDate("2015-04-14");
	    document[0].setNumber("00000000");
	    document[0].setExpiryDate("2025-04-14");
	    document[0].setIssuanceCountry("ES");
	    document[0].setValidityCountry("ES");
	    document[0].setNationality("ES");
	    document[0].setHolder(true);
	    traveler.setDocuments(document);
	}
}
class Viajante extends Traveler{
	public class Contato extends Traveler.Contact{
		private String emailAddress;
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
	}
	public class Documento extends Traveler.Document{
		private String birthPlace;
		private String issuanceLocation;
		private String issuanceDate;
		private String validityCountry;
		public String getBirthPlace() {
			return birthPlace;
		}
		public void setBirthPlace(String birthPlace) {
			this.birthPlace = birthPlace;
		}
		public String getIssuanceLocation() {
			return issuanceLocation;
		}
		public void setIssuanceLocation(String issuanceLocation) {
			this.issuanceLocation = issuanceLocation;
		}
		public String getIssuanceDate() {
			return issuanceDate;
		}
		public void setIssuanceDate(String issuanceDate) {
			this.issuanceDate = issuanceDate;
		}
		public String getValidityCountry() {
			return validityCountry;
		}
		public void setValidityCountry(String validityCountry) {
			this.validityCountry = validityCountry;
		}
		
	}
}
