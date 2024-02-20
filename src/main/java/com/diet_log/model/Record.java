package com.diet_log.model;

public class Record {
    String name;
    double energy;
    double fat;
    double saturatedFat;
    double carbohydrates;
    double sugars;
    double fiber;
    double protein;

    public Record(String name, double energy, double fat, double saturatedFat, double carbohydrates, double sugars, double fiber, double protein) {
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

}
