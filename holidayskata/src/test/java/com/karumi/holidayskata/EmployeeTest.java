package com.karumi.holidayskata;

import com.karumi.holidayskata.mother.DateMother;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    private static final String ANY_EMPLOYEE = "Paul";

    @Test
    public void shouldReturnTrueIfTheWorkerIsOnHolidaysThisDay() {
        Employee employee = new Employee(ANY_EMPLOYEE);
        Date employeeIsOut = DateMother.givenDayEmployeeIsOut();
        employee.addHolidays(employeeIsOut);

        boolean onHolidays = employee.isOnHolidays(employeeIsOut);

        assertTrue(onHolidays);
    }
}
