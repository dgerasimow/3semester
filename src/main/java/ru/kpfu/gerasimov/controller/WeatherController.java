package ru.kpfu.gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.gerasimov.aspect.Loggable;
import ru.kpfu.gerasimov.dto.WeatherDto;
import ru.kpfu.gerasimov.model.Request;
import ru.kpfu.gerasimov.model.User;
import ru.kpfu.gerasimov.model.WeatherModel;
import ru.kpfu.gerasimov.model.weather.WeatherInfo;
import ru.kpfu.gerasimov.repository.RequestRepository;
import ru.kpfu.gerasimov.repository.UserRepository;
import ru.kpfu.gerasimov.repository.WeatherRepository;
import ru.kpfu.gerasimov.services.NetworkService;
import ru.kpfu.gerasimov.services.WeatherService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
public class WeatherController {

    private final NetworkService networkService;

    private final WeatherRepository weatherRepository;

    private final UserRepository userRepository;

    private final RequestRepository requestRepository;

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(NetworkService networkService, WeatherRepository weatherRepository,
                             UserRepository userRepository,
                             RequestRepository requestRepository,
                             WeatherService weatherService) {
        this.networkService = networkService;
        this.weatherRepository = weatherRepository;
        this.userRepository = userRepository;
        this.requestRepository= requestRepository;
        this.weatherService = weatherService;
    }

    @Loggable
    @GetMapping("/weather")
    public WeatherDto getWeather(@RequestParam Optional<String> city, Authentication authentication) {

        if(city.isPresent()){
            if (authentication.isAuthenticated()) {
                WeatherInfo fetchedData = networkService.fetchData(city.get());
                WeatherModel weatherModel = new WeatherModel(city.get(),
                        fetchedData.getWeather().get(0).getMain(),
                        Double.toString(fetchedData.getMain().getTemp()));
                WeatherDto returnModel = WeatherDto.fromModel(weatherRepository.save(weatherModel));
                System.out.println(authentication.getName());

                requestRepository.save(new Request(Timestamp.from(Instant.now()),
                        userRepository.getUserByEmail(authentication.getName()).orElse(new User()),
                        weatherModel));
                return returnModel;
            }
            return new WeatherDto();
        } else {
            return new WeatherDto();
        }
    }

    @GetMapping("/allweather")
    public Iterable<WeatherModel> getAllWeather() {
        return weatherRepository.findAll();
    }

    private Boolean isUserExistByEmail(String email) {
        Iterable<User> user = userRepository.findAll();
        return StreamSupport.stream(user.spliterator(), false)
                .anyMatch(u -> u.getEmail().equals(email));
    }

    private User getUserByEmail(String email) {
        Iterable<User> user = userRepository.findAll();
            return StreamSupport.stream(user.spliterator(), false)
                    .findFirst().orElse(new User());

    }

    @GetMapping("/weather/by-city")
    public List<WeatherDto> requestByCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }

}
