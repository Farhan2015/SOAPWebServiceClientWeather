package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCitiesByCountry;
import hello.wsdl.GetCitiesByCountryResponse;

public class CitiesByCountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CitiesByCountryClient.class);

	public GetCitiesByCountryResponse getCitiesByCountry(String country) {

		GetCitiesByCountry request = new GetCitiesByCountry();
		request.setCountryName(country);

		log.info("Requesting cities for " + country);

		GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx", request, new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));

		return response;
	}

}