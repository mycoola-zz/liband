package com.liband.room.converters;

import android.arch.persistence.room.TypeConverter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TimestampConverter {

    @TypeConverter
    public static Date fromTimestamp(DateFormat dateFormat, String value) {
        if (value != null) {
            try {
                return dateFormat.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToTimestamp(DateFormat dateFormat, Date value) {

        return value == null ? null : dateFormat.format(value);
    }
}
