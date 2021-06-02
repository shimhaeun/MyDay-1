package org.ict.myday.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public final static String CALENDAR_HEADER_FORMAT = "yyyy년MM월";
    public final static String YEAR_FORMAT = "yyyy";
    public final static String MONTH_FORMAT = "MM";
    public final static String DAY_FORMAT = "d";
    public final static String HOUR_FORMAT = "HH";
    public final static String MIN_FORMAT = "mm";
    public final static String SEC_FORMAT = "ss";

    public static String getDate(long date, String pattern) {
        try {
            // SimpleDateFormat으로 날짜를 쉽게 가져올 수 있다.
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Date d = new Date(date);
            return sdf.format(d).toUpperCase();
        } catch (Exception e){
            return " ";
        }
    }
}


