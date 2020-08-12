package com.ivanwidyan.module.api.response.updateuser;

import lombok.Data;

@Data
public class UpdateUserResponse {
    private String name;

    public String getName() {
        return name;
    }

    public UpdateUserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UpdateUserResponse setJob(String job) {
        this.job = job;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UpdateUserResponse setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    private String job;
    private String updatedAt;
}