package com.gama.passagens.amadeus;

import org.springframework.stereotype.Component;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Traveler;
import com.amadeus.resources.Traveler.Document;
import com.amadeus.resources.Traveler.Phone;

//@Component
public class AmadeusStart {
	private Amadeus amadeus;
	public void start() {
		this.amadeus = Amadeus
				.builder("RZ3pbc22VwLAXtXqIU80DmT2hv1M2J8y", "zVyCOrYgU6ThENBK")
				.build();
		
		try {
			listarVoos();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void listarVoos() throws Exception {
		FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
	              Params.with("originLocationCode", "NYC")
                      .and("destinationLocationCode", "MAD")
                      .and("departureDate", "2020-11-05")
                      .and("returnDate", "2020-11-08")
                      .and("adults", 1)
                      .and("max", 3));
		
		//System.out.println(flightOffersSearches);
	
		fluxoCompleto(flightOffersSearches[0]);
	}
	public void fluxoCompleto(FlightOfferSearch search) throws Exception {
		
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

	    Traveler[] travelerArray = new Traveler[1];
	    travelerArray[0] = traveler;
	    System.out.println(travelerArray[0]);
	    
	    
	 // We price the 2nd flight of the list to confirm the price and the availability
	    FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(search);

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


