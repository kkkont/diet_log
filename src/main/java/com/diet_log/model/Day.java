package com.diet_log.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Day {
    UUID user;
    LocalDate date;
    List<Record> recordList;

    public Day(UUID user) {
        this.user = user;
        this.date = LocalDate.now();
        this.recordList = new ArrayList<>();
    }

    public void addRecordToList(Record record) {
        recordList.add(record);
    }

    public double getCalorieIntake() {
        double calories = 0;
        for (Record record : recordList) {
            calories += record.energy;
        }
        return calories;
    }

    public double getFatIntake() {
        double fat = 0;
        for (Record record : recordList) {
            fat += record.fat;
        }
        return fat;
    }

    public double getSaturatedFatIntake() {
        double fat = 0;
        for (Record record : recordList) {
            fat += record.saturatedFat;
        }
        return fat;
    }

    public double getCarbohydratesIntake() {
        double carbohydrates = 0;
        for (Record record : recordList) {
            carbohydrates += record.carbohydrates;
        }
        return carbohydrates;
    }

    public double getSugarsIntake() {
        double sugars = 0;
        for (Record record : recordList) {
            sugars += record.sugars;
        }
        return sugars;
    }

    public double getFiberIntake() {
        double fiber = 0;
        for (Record record : recordList) {
            fiber += record.fiber;
        }
        return fiber;
    }

    public double getProteinIntake() {
        double protein = 0;
        for (Record record : recordList) {
            protein += record.protein;
        }
        return protein;
    }

    public String dayOverViewAllRecordsByEnergy(){
        StringBuilder output = new StringBuilder();
        for(Record record:recordList){
            output.append(record.name + ": " + record.energy + " kcal\n");
        }
        return String.valueOf(output);
    }
    public String dayOverView() {
        return date + " OVERVIEW\n" +
                "=".repeat(20) +
                "\nEnergy (kcal): " + getCalorieIntake() +
                "\nFat: " + getFatIntake() +
                "\nSaturate fat: " + getSaturatedFatIntake() +
                "\nCarbohydates: " + getCarbohydratesIntake() +
                "\nSugars: " + getSugarsIntake() +
                "\nFiber: " + getFiberIntake() +
                "\nProtein: " + getProteinIntake();
    }

    @Override
    public String toString() {
        return "Day{" +
                "user=" + user +
                ", date=" + date +
                ", recordList=" + recordList +
                '}';
    }
}