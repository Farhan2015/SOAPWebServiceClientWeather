package hello;

import hello.wsdl.GetCitiesByCountryResponse;
import hello.wsdl.GetWeatherResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(WeatherClient weatherClient) {
		return args -> {
			String city = "Varanasi";
			String country = "India";

			//if (args.length > 0) {
			//	ticker = args[0];
			//}
			GetWeatherResponse response = weatherClient.getWeather(city, country);
			System.err.println(response.getGetWeatherResult());
		};
	}

}