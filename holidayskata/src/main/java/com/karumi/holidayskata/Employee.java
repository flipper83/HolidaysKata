package com.karumi.holidayskata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private final String name;
    private List<Date> holidays = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public boolean isOnHolidays(Date date) {
        for (Date holiday : holidays) {
            if(date.equals(holiday)) {
                return true;
            }
        }
        return false;
    }

    public void addHolidays(Date employeeIsOut) {
        holidays.add(employeeIsOut);
    }

    public void addHolidays(HolidayPeriod employeeIsOut) {

    }

    public boolean isOnHolidays(HolidayPeriod overlapPeriod) {
        return false;
    }
}
