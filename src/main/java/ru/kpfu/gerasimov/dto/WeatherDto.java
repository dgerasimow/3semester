package ru.kpfu.gerasimov.dto;

import ru.kpfu.gerasimov.model.WeatherModel;

import java.sql.Timestamp;
import java.time.Instant;

public class WeatherDto {
    private Long id;

    private Timestamp timestamp;

    private String city;

    private String weatherType;

    private String temp;

    private String requesterEmail;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

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

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public WeatherDto(Long id, Timestamp timestamp, String city, String weatherType, String temp, String requesterEmail) {
        this.id = id;
        this.timestamp = timestamp;
        this.city = city;
        this.weatherType = weatherType;
        this.temp = temp;
        this.requesterEmail = requesterEmail;
    }

    public static WeatherDto fromModel(WeatherModel weather) {
        return new WeatherDto(weather.getId(), weather.getTimestamp(),
                weather.getCity(), weather.getWeatherType(),
                weather.getTemp(), weather.getRequesterEmail());
    }

    public WeatherDto() {}
}
