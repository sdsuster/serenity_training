package com.ivanwidyan.module.api.data;

import lombok.*;

import java.util.List;

@Data
public class Pokemon {
    public int getNumber() {
        return number;
    }

    public Pokemon setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pokemon setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public Pokemon setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public Pokemon setHeight(float height) {
        this.height = height;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public Pokemon setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public String getJapanName() {
        return japanName;
    }

    public Pokemon setJapanName(String japanName) {
        this.japanName = japanName;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Pokemon setHp(int hp) {
        this.hp = hp;
        return this;
    }

    private int number;
    private String name;
    private List<String> types;
    private float height, weight;
    private int hp;
    private String japanName;
}
