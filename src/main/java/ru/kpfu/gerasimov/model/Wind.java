package ru.kpfu.gerasimov.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
    private double speed;
    private long deg;
    private long gust;

    @JsonProperty("speed")
    public double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(double value) {
        this.speed = value;
    }

    @JsonProperty("deg")
    public long getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(long value) {
        this.deg = value;
    }

    @JsonProperty("gust")
    public long getGust() {
        return gust;
    }

    @JsonProperty("gust")
    public void setGust(long value) {
        this.gust = value;
    }
}
