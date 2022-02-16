package ru.kpfu.gerasimov.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "weather")
public class WeatherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp timestamp;

    private String city;

    private String weatherType;

    private String temp;

    private String requesterEmail;

    public WeatherModel() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public WeatherModel(Timestamp timestamp, String city, String weatherType, String temp, String requesterEmail) {
        this.timestamp = timestamp;
        this.city = city;
        this.weatherType = weatherType;
        this.temp = temp;
        this.requesterEmail = requesterEmail;
    }
}
