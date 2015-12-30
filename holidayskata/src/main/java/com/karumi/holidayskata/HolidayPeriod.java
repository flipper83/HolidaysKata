package com.karumi.holidayskata;

import java.util.Date;

public class HolidayPeriod {
    private Date startPeriod;
    private Date endPeriod;

    public HolidayPeriod(Date dayOut) {
        startPeriod = dayOut;
        endPeriod = dayOut;
    }

    public HolidayPeriod(Date startPeriod, Date endPeriod) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }

    public boolean isOverlap(HolidayPeriod overlapPeriod) {
        if (overlapPeriod.startPeriod.equals(startPeriod)
                || overlapPeriod.startPeriod.equals(endPeriod)
                || overlapPeriod.endPeriod.equals(endPeriod)
                || overlapPeriod.endPeriod.equals(startPeriod)) {
            return true;
        }

        if (overlapPeriod.startPeriod.before(endPeriod)
                && overlapPeriod.startPeriod.after(startPeriod)) {
            return true;
        }

        if (startPeriod.before(overlapPeriod.endPeriod)
                && startPeriod.after(overlapPeriod.startPeriod)) {
            return true;
        }


        return false;
    }
}
