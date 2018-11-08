package com.liband.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

class DateUtil {

    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        return simpleDateFormat.parse(dateString);
    }

    public static String getCurrentTimeStampWithWMA() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",Locale.US);
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static String getCurrentTimeStampWithoutFormat() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-mm-ss",Locale.US);// dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static String getCurrentTimeStampWithYearMonthDaysMintusSeconds() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd mm:ss",Locale.US);// dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static String getCurrentTimeStampWithoutFormatDayFirst() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy",Locale.US);// dd/MM/yyyy
        Calendar calendar = Calendar.getInstance();
        return sdfDate.format(calendar.getTime());

    }

    public static String getYesterdayDateString(int i) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.US);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, i);
        return dateFormat.format(cal.getTime());
    }

    public static String addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        return sdfDate.format(cal.getTime());
    }

    public static int[] GetYearMonthDay(String Date) {

        String[] parts = Date.split("-");
        if (parts.length == 3) {
            int year, month, day;

            year = Integer.parseInt(parts[2]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[0]);
            return new int[]{year, month, day};
        }
        return null;
    }

    public static boolean isOldDate(int[] x) {
        if (Calendar.getInstance().get(Calendar.YEAR) <= x[0])
            if (Calendar.getInstance().get(Calendar.MONTH) + 1 <= x[1])
                return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > x[2];
        return true;
    }

    public static String permissionNoteDate(String dateString) {
        try {
            SimpleDateFormat formatFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.US);
            SimpleDateFormat formatTo = new SimpleDateFormat("EEE, dd MMM yyyy, hh:mm aaa",Locale.US);
            SimpleDateFormat formatTo2 = new SimpleDateFormat("EEE, dd MMM yyyy 'at' hh:mm aaa",Locale.US);
            SimpleDateFormat formatTo3 = new SimpleDateFormat("EEE, dd MMM, hh:mm aaa",Locale.US);
            Date date = formatFrom.parse(dateString);

            String folderName = formatTo.format(date);
            String folderName2 = formatTo2.format(date);

            return formatTo3.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDateFormatFromAnother(String dateFormatOne, String dateFormattow, String date) {
        try {
            Date temp = new SimpleDateFormat(dateFormatOne, Locale.US).parse(date);
            SimpleDateFormat sdfDate = new SimpleDateFormat(dateFormattow, Locale.US);// dd/MM/yyyy
            return sdfDate.format(temp);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, 0);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_YEAR, 0);
        cal.set(Calendar.DAY_OF_WEEK, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static XMLGregorianCalendar removeXMLGregorianCalendarNow() throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(removeTime(new Date()));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    }

    public static XMLGregorianCalendar getXMLGregorianCalendarNow() throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        return datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
    }

    public static boolean isValid(String value) {
        try {
            new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getDateTimeFormatted(String dateString) {
        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.US);
        timeStamp.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = timeStamp.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdfDateOnly = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        SimpleDateFormat sdfDateTime = new SimpleDateFormat("HH:mm a",Locale.US);

        return sdfDateOnly.format(date) +
                "\n" +
                sdfDateTime.format(date);
    }

    public static String getTimeFormatted(String dateString) {
        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.US);
        timeStamp.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = timeStamp.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdfDateTime = new SimpleDateFormat("hh:mm a",Locale.US);
        return sdfDateTime.format(date);
    }

    public static String getSOQLDateTimeFormatted(Calendar calendar) {
        SimpleDateFormat sdfDateOnly = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",Locale.US);

        return sdfDateOnly.format(calendar.getTime());
    }
}
