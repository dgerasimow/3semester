package ru.kpfu.gerasimov.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    private String cod;
    private String message;

    @JsonProperty("cod")
    public String getCod() { return cod; }
    @JsonProperty("cod")
    public void setCod(String value) { this.cod = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }
}