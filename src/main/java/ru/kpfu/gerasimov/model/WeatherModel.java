package ru.kpfu.gerasimov.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "weather")
public class WeatherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String city;

    @Column
    private String weatherType;

    @Column
    private String temp;

    @OneToOne(mappedBy = "weather")
    private Request request;


    public WeatherModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
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


    public WeatherModel(String city, String weatherType, String temp) {
        this.city = city;
        this.weatherType = weatherType;
        this.temp = temp;
    }
}
