package com.luv2code.hibernate.demo.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    // read a date string and parse/convert it into date
    public static Date parseDate(String dateStr) throws ParseException {

        return formatter.parse(dateStr);
    }

    // read a date and format/convert it to a string

    public static String formatDate(Date theDate) {
        if (theDate != null) {
            return formatter.format(theDate);
        } else {
            return null;
        }
    }

}
