package com.ivanwidyan.module.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Type{
    public Type() {
    }

    DetailType type;

    public DetailType getType() {
        return type;
    }

    public Type setType(DetailType type) {
        this.type = type;
        return this;
    }
}
