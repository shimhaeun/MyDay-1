package org.ict.myday.Model;

import org.ict.myday.Util.DateUtil;

import java.util.Calendar;

public class Day extends ViewModel {
    String day;

    public Day() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCalendar(Calendar calendar) {
        day = DateUtil.getDate(calendar.getTimeInMillis(), DateUtil.DAY_FORMAT);
    }
}
