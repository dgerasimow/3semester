package ru.kpfu.gerasimov.services;

import org.springframework.stereotype.Component;
import ru.kpfu.gerasimov.model.weather.ConverterWelcome;
import ru.kpfu.gerasimov.model.weather.WeatherInfo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class NetworkService {
    public WeatherInfo fetchData(String city) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=0d2466174600c426bea83f7208a2ed81&units=metric"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            LOGGER.info(response.body());

            return ConverterWelcome.fromJsonString(response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return new WeatherInfo();
    }

}
