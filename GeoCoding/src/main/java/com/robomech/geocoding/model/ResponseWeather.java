package com.robomech.geocoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseWeather {

    private Weather[] weather;
    private Main main;
    @JsonProperty("coord")
    private Coordinate coordinate;

    // Getter for weather array
    public Weather[] getWeather() {
        return weather;
    }

    // Setter for weather array
    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    // Getter for main
    public Main getMain() {
        return main;
    }

    // Setter for main
    public void setMain(Main main) {
        this.main = main;
    }

    // Getter for coordinate
    public Coordinate getCoordinate() {
        return coordinate;
    }

    // Setter for coordinate
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

