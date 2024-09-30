package com.robomech.geocoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    
    @JsonProperty("results")
    private Result[] result;

    // Getter for result array
    public Result[] getResult() {
        return result;
    }

    // Setter for result array
    public void setResult(Result[] result) {
        this.result = result;
    }
}

