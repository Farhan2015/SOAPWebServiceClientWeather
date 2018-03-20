package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetWeather;
import hello.wsdl.GetWeatherResponse;

public class WeatherClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

	public GetWeatherResponse getWeather(String city, String country) {

		GetWeather request = new GetWeather();
		request.setCityName(city);
		request.setCountryName(country);

		log.info("Requesting weather for " + city);

		GetWeatherResponse response = (GetWeatherResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx", request, new SoapActionCallback("http://www.webserviceX.NET/GetWeather"));

		return response;
	}

}