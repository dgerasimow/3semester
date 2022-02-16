package ru.kpfu.gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.gerasimov.dto.WeatherDto;
import ru.kpfu.gerasimov.model.User;
import ru.kpfu.gerasimov.model.WeatherModel;
import ru.kpfu.gerasimov.model.weather.WeatherInfo;
import ru.kpfu.gerasimov.respository.UserRepository;
import ru.kpfu.gerasimov.respository.WeatherRepository;
import ru.kpfu.gerasimov.services.NetworkService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
public class WeatherController {

    private final NetworkService networkService;

    private final WeatherRepository weatherRepository;

    private final UserRepository userRepository;

    @Autowired
    public WeatherController(NetworkService networkService, WeatherRepository weatherRepository,
                             UserRepository userRepository) {
        this.networkService = networkService;
        this.weatherRepository = weatherRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/weather")
    public WeatherDto weather(@RequestParam Optional<String> city,
                               @RequestParam Optional<String> email) {
        System.out.println(city);
        System.out.println(email);
        if(city.isPresent() && email.isPresent()){
            if (isUserExistByEmail(email.get())) {
                WeatherInfo fetchedData = networkService.fetchData(city.get());
                return WeatherDto.fromModel(weatherRepository.save(new WeatherModel(Timestamp.from(Instant.now()), city.get(),
                        fetchedData.getWeather().get(0).getMain(),
                        Double.toString(fetchedData.getMain().getTemp()), email.get())));
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


}
