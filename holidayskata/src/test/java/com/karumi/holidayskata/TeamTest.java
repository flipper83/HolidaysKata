package com.karumi.holidayskata;

import com.karumi.holidayskata.mother.DateMother;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamTest {
    private static final String ANY_NAME = "Paul";

    @Test
    public void shouldReturnTeamMembersAvailablesForGivenDate() {
        Team team = new Team();
        Date date = DateMother.givenDayEmployeeIsOut();
        team.addMember(givenEmployee(date));
        team.addMember(givenEmployee(date));

        List<Employee> employees = team.membersAvailables(DateMother.givenAnyDate());

        assertEquals(2, employees.size());
    }

    @Test
    public void shouldReturnAnyTeamMembersAvailablesForGivenPeriod() {
        Team team = new Team();
        HolidayPeriod period = DateMother.givenPeriodEmployeeIsOut();
        HolidayPeriod periodSecondEmployee = DateMother.givenPeriodOtherEmployeeIsOut();
        team.addMember(givenEmployee(period));
        team.addMember(givenEmployee(periodSecondEmployee));
        HolidayPeriod overlapPeriod = DateMother.givenOverlapPeriod();

        List<Employee> employees = team.membersAvailables(overlapPeriod);

        assertEquals(0, employees.size());
    }

    private Employee givenEmployee(HolidayPeriod holidayPeriod) {
        Employee employee = new Employee(ANY_NAME);
        employee.addHolidays(holidayPeriod);
        return employee;
    }

    private Employee givenEmployee(Date date) {
        Employee employee = new Employee(ANY_NAME);
        employee.addHolidays(date);
        return employee;
    }
}
