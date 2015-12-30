package com.karumi.holidayskata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private final String name;
    private List<HolidayPeriod> holidays = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public boolean isOnHolidays(Date date) {
        HolidayPeriod holidayPeriod = new HolidayPeriod(date);
        return isOnHolidays(holidayPeriod);
    }

    public boolean isOnHolidays(HolidayPeriod overlapPeriod) {
        for (HolidayPeriod holidayPeriod : holidays) {
            if(holidayPeriod.isOverlap(overlapPeriod)) {
                return true;
            }
        }
        return false;
    }

    public void addHolidays(Date employeeIsOut) {
        HolidayPeriod holidayPeriod = new HolidayPeriod(employeeIsOut);
        holidays.add(holidayPeriod);
    }

    public void addHolidays(HolidayPeriod employeeIsOut) {
        holidays.add(employeeIsOut);
    }
}
