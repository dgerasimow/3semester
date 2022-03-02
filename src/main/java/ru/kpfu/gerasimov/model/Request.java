package ru.kpfu.gerasimov.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "weather_id")
    private WeatherModel weather;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WeatherModel getWeather() {
        return weather;
    }

    public void setWeather(WeatherModel weather) {
        this.weather = weather;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Request(Timestamp timestamp, User user, WeatherModel weather) {
        this.timestamp = timestamp;
        this.user = user;
        this.weather = weather;
    }

    public Request(){}
}
