package com.karumi.holidayskata;

import com.karumi.holidayskata.mother.DateMother;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamTest {
    private static final String ANY_NAME = "Paul";
    private static final String ANY_ROLE = "any_role";

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

    @Test
    public void shouldReturnEmployeesAvailablesForGivenPeriodAndFilterByRole() {
        Team team = new Team();
        HolidayPeriod period = DateMother.givenPeriodEmployeeIsOut();
        HolidayPeriod periodSecondEmployee = DateMother.givenPeriodOtherEmployeeIsOut();
        team.addMember(givenEmployee(period));
        team.addMember(givenEmployee(periodSecondEmployee, "support"));
        HolidayPeriod anyPeriod = DateMother.givenAnyHolidayPeriod();

        List<Employee> employees = team.membersAvailables(anyPeriod,"support");

        assertEquals(1, employees.size());
        assertEquals("support", employees.get(0).getRole());
    }

    private Employee givenEmployee(HolidayPeriod holidayPeriod, String role) {
        Employee employee = new Employee(ANY_NAME);
        employee.setRole(role);
        employee.addHolidays(holidayPeriod);
        return employee;
    }

    private Employee givenEmployee(HolidayPeriod holidayPeriod) {
        return givenEmployee(holidayPeriod, ANY_ROLE);
    }

    private Employee givenEmployee(Date date) {
        Employee employee = new Employee(ANY_NAME);
        employee.addHolidays(date);
        return employee;
    }
}
