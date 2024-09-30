package com.robomech.geocoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("formatted_address")
    private String address;
    //@JsonProperty("geomertry")
    private Geometry geometry;

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for geometry
    public Geometry getGeometry() {
        return geometry;
    }

    // Setter for geometry
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
