package ru.kpfu.gerasimov.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.gerasimov.dto.WeatherDto;
import ru.kpfu.gerasimov.respository.WeatherRepository;
import ru.kpfu.gerasimov.services.WeatherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDto> getWeatherByCity(String city) {
        return weatherRepository.getWeatherByCity(city).stream()
                .map(WeatherDto::fromModel)
                .collect(Collectors.toList());
    }
}
