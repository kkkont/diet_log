package com.diet_log.model;

import java.util.UUID;

public class Record {
    UUID user;
    String name;
    double energy;
    double fat;
    double saturatedFat;
    double carbohydrates;
    double sugars;
    double fiber;
    double protein;

    public Record(UUID user,String name, double energy, double fat, double saturatedFat, double carbohydrates, double sugars, double fiber, double protein) {
        this.user = user;
        this.name = name;
        this.energy = energy;
        this.fat = fat;
        this.saturatedFat = saturatedFat;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fiber = fiber;
        this.protein = protein;
    }

    public void EditRecord(String name, double energy, double fat, double saturatedFat, double carbohydrates, double sugars, double fiber, double protein){
        this.name = name;
        this.energy = energy;
        this.fat = fat;
        this.saturatedFat = saturatedFat;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fiber = fiber;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Record{" +
                "user=" + user +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", fat=" + fat +
                ", saturatedFat=" + saturatedFat +
                ", carbohydrates=" + carbohydrates +
                ", sugars=" + sugars +
                ", fiber=" + fiber +
                ", protein=" + protein +
                '}';
    }
}
