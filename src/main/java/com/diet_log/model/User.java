package com.diet_log.model;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    String name;
    String password;
    int recommendedCalorieIntake;
    int actualCalorieIntake;
    LocalDateTime lastUpdated;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.lastUpdated = LocalDateTime.now();
    }

    public User(String name, String password, int recommendedCalorieIntake) {
        this.name = name;
        this.password = password;
        this.recommendedCalorieIntake = recommendedCalorieIntake;
        this.lastUpdated = LocalDateTime.now();
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

    public int getActualCalorieIntake() {
        return actualCalorieIntake;

    }

    public void setActualCalorieIntake(int actualCalorieIntake) {
        this.actualCalorieIntake = actualCalorieIntake;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", recommendedCalorieIntake=" + recommendedCalorieIntake +
                ", actualCalorieIntake=" + actualCalorieIntake +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
