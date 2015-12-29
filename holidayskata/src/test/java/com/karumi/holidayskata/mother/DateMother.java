package com.karumi.holidayskata.mother;

import java.util.Calendar;
import java.util.Date;

public final class DateMother {
    public final static Date givenDayEmployeeIsOut() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        return calendar.getTime();
    }

    public static Date givenAnyDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        return calendar.getTime();
    }
}
