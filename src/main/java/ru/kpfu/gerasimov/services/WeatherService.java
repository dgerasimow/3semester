package ru.kpfu.gerasimov.services;

import ru.kpfu.gerasimov.dto.WeatherDto;

import java.util.List;

public interface WeatherService {

    List<WeatherDto> getWeatherByCity(String city);
}
