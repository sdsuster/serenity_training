package com.ivanwidyan.module.api.response.createuser;

import lombok.Data;

@Data
public class CreateUserResponse {
    public String getName() {
        return name;
    }

    public CreateUserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public CreateUserResponse setJob(String job) {
        this.job = job;
        return this;
    }

    public int getId() {
        return id;
    }

    public CreateUserResponse setId(int id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CreateUserResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    private String name;
    private String job;
    private int id;
    private String createdAt;

}