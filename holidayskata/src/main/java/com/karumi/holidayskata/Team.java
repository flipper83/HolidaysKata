package com.karumi.holidayskata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Team {
    private List<Employee> employees = new ArrayList<>();

    public void addMember(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> membersAvailables(Date date) {
        HolidayPeriod holidayPeriod = new HolidayPeriod(date);
        return membersAvailables(holidayPeriod);
    }

    public List<Employee> membersAvailables(HolidayPeriod period) {
        List<Employee> availables = new ArrayList<>();
        for (Employee employee : employees) {
            if(!employee.isOnHolidays(period)) {
                availables.add(employee);
            }
        }
        return availables;
    }
}
