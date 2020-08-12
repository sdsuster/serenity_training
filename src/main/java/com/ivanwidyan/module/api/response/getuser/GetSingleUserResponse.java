package com.ivanwidyan.module.api.response.getuser;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetSingleUserResponse {
    private GetSingleUserResponseData data;
    private GetSingleUserResponseAd ad;

    public GetSingleUserResponseData getData() {
        return data;
    }

    public GetSingleUserResponse setData(GetSingleUserResponseData data) {
        this.data = data;
        return this;
    }

    public GetSingleUserResponseAd getAd() {
        return ad;
    }

    public GetSingleUserResponse setAd(GetSingleUserResponseAd ad) {
        this.ad = ad;
        return this;
    }
}
