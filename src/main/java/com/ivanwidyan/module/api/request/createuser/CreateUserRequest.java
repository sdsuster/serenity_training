package com.ivanwidyan.module.api.request.createuser;

import lombok.*;

@Data
public class CreateUserRequest {
    public String getName() {
        return name;
    }

    public CreateUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public CreateUserRequest setJob(String job) {
        this.job = job;
        return this;
    }

    private String name;
    private String job;
}
