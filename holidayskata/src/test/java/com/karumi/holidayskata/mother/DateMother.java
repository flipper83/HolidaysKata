package com.karumi.holidayskata.mother;

import com.karumi.holidayskata.HolidayPeriod;

import java.util.Calendar;
import java.util.Date;

public final class DateMother {
    public final static Date givenDayEmployeeIsOut() {
        return getDate(Calendar.JANUARY, 4, 2015);
    }

    public static Date givenAnyDate() {
        return getDate(Calendar.FEBRUARY, 7, 2015);
    }

    public static HolidayPeriod givenPeriodEmployeeIsOut() {
        Date start = getDate(Calendar.JANUARY, 7, 2015);
        Date end = getDate(Calendar.JANUARY, 11, 2015);
        return new HolidayPeriod(start, end);
    }
    public static HolidayPeriod givenPeriodOtherEmployeeIsOut() {
        Date start = getDate(Calendar.JANUARY, 8, 2015);
        Date end = getDate(Calendar.JANUARY, 12, 2015);
        return new HolidayPeriod(start, end);
    }

    public static HolidayPeriod givenOverlapPeriod() {
        Date start = getDate(Calendar.JANUARY, 9, 2015);
        Date end = getDate(Calendar.JANUARY, 10, 2015);
        return new HolidayPeriod(start, end);
    }

    private static Date getDate(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
