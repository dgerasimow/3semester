package ru.kpfu.gerasimov.dto;

import ru.kpfu.gerasimov.model.Request;

import java.sql.Timestamp;

public class RequestDto {
    private Integer id;

    private Timestamp timestamp;

    private Integer userId;

    private Integer weatherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public RequestDto(Integer id, Timestamp timestamp, Integer userId, Integer weatherId) {
        this.id = id;
        this.timestamp = timestamp;
        this.userId = userId;
        this.weatherId = weatherId;
    }

    static public RequestDto fromModel(Request request) {
        return new RequestDto(request.getId(),
                request.getTimestamp(),
                request.getUser().getId(),
                request.getWeather().getId());
    }
}
