package com.ivanwidyan.module.api.request.updateuser;

import lombok.Data;

@Data
public class UpdateUserRequest {
    public String getName() {
        return name;
    }

    public UpdateUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UpdateUserRequest setJob(String job) {
        this.job = job;
        return this;
    }

    private String name;
    private String job;

}
