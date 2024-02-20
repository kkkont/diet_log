package com.diet_log;

import com.diet_log.model.Day;
import com.diet_log.model.Record;
import com.diet_log.model.User;

public class MainApp {
    public static void main(String[] args) {
        User user = new User("kadri","Kadri2003");
        Day day = new Day(user.getId());
        System.out.println(user);
        Record record = new Record(user.getId(), "Toit", 2,3,4,5,1,2,3);
        day.addRecordToList(record);
        System.out.println(record);
        System.out.println(day.dayOverView());
    }
}
