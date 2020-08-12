package com.ivanwidyan.module.api.response.getuser;

import lombok.Data;

@Data
public class GetSingleUserResponseData {
    private int id;

    public int getId() {
        return id;
    }

    public GetSingleUserResponseData setId(int id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GetSingleUserResponseData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public GetSingleUserResponseData setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public GetSingleUserResponseData setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public GetSingleUserResponseData setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
