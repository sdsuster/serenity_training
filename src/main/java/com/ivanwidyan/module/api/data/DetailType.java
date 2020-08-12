package com.ivanwidyan.module.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailType{
    public DetailType() {
    }

    public String getName() {
        return name;
    }

    public DetailType setName(String name) {
        this.name = name;
        return this;
    }

    private String name;
}