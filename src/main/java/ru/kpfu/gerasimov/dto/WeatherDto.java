package ru.kpfu.gerasimov.dto;

import ru.kpfu.gerasimov.model.WeatherModel;

import java.sql.Timestamp;
import java.time.Instant;

public class WeatherDto {
    private Integer id;


    private String city;

    private String weatherType;

    private String temp;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public WeatherDto(Integer id, String city, String weatherType, String temp) {
        this.id = id;
        this.city = city;
        this.weatherType = weatherType;
        this.temp = temp;
    }

    public static WeatherDto fromModel(WeatherModel weather) {
        return new WeatherDto(weather.getId(),
                weather.getCity(), weather.getWeatherType(),
                weather.getTemp());
    }

    public WeatherDto() {}
}
