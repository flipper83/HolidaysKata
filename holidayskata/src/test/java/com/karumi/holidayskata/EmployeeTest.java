package com.karumi.holidayskata;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    private static final String ANY_EMPLOYEE = "Paul";

    @Test
    public void shouldReturnTrueIfTheWorkerIsOnHolidaysThisDay() {
        Employee employee = new Employee(ANY_EMPLOYEE);
        Date employeeIsOut = givenDayEmployeeIsOut();
        employee.addHolidays(employeeIsOut);

        boolean onHolidays = employee.isOnHolidays(employeeIsOut);

        assertTrue(onHolidays);
    }

    private Date givenDayEmployeeIsOut() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        return calendar.getTime();
    }
}
