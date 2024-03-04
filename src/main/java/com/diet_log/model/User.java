package com.diet_log.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    UUID id;
    String name;
    String password;
    int recommendedCalorieIntake;

    public User(String name, String password) {
        this.id =  UUID.randomUUID();
        this.name = name;
        this.password = password;

    }

    public User(String name, String password, int recommendedCalorieIntake) {
        this.id =  UUID.randomUUID();
        this.name = name;
        this.password = password;
        this.recommendedCalorieIntake = recommendedCalorieIntake;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRecommendedCalorieIntake() {
        return recommendedCalorieIntake;
    }

    public void setRecommendedCalorieIntake(int recommendedCalorieIntake) {
        this.recommendedCalorieIntake = recommendedCalorieIntake;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", recommendedCalorieIntake=" + recommendedCalorieIntake + "}";
    }
}
