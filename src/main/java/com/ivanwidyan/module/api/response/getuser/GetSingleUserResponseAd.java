package com.ivanwidyan.module.api.response.getuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSingleUserResponseAd {
    private String company;
    private String url;
    private String text;
}
