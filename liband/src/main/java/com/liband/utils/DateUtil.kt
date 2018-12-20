package com.liband.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConfigurationException
import javax.xml.datatype.DatatypeFactory
import javax.xml.datatype.XMLGregorianCalendar

object DateUtil {

    val currentTimeStampWithWMA: String
        get() {
            val sdfDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)
            val now = Date()
            return sdfDate.format(now)
        }

    // dd/MM/yyyy
    val currentTimeStampWithoutFormat: String
        get() {
            val sdfDate = SimpleDateFormat("yyyy-MM-dd-mm-ss", Locale.US)
            val now = Date()
            return sdfDate.format(now)
        }

    // dd/MM/yyyy
    val currentTimeStampWithYearMonthDaysMintusSeconds: String
        get() {
            val sdfDate = SimpleDateFormat("yyyy-MM-dd mm:ss", Locale.US)
            val now = Date()
            return sdfDate.format(now)
        }

    // dd/MM/yyyy
    val currentTimeStampWithoutFormatDayFirst: String
        get() {
            val sdfDate = SimpleDateFormat("dd-MM-yyyy", Locale.US)
            val calendar = Calendar.getInstance()
            return sdfDate.format(calendar.time)

        }

    val xmlGregorianCalendarNow: XMLGregorianCalendar
        @Throws(DatatypeConfigurationException::class)
        get() {
            val gregorianCalendar = GregorianCalendar()
            val datatypeFactory = DatatypeFactory.newInstance()
            return datatypeFactory.newXMLGregorianCalendar(gregorianCalendar)
        }

    @Throws(ParseException::class)
    fun convertStringToDate(dateString: String): Date {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return simpleDateFormat.parse(dateString)
    }

    fun getYesterdayDateString(i: Int): String {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, i)
        return dateFormat.format(cal.time)
    }

    fun addDays(date: Date, days: Int): String {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, days)

        val sdfDate = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return sdfDate.format(cal.time)
    }

    fun getYearMonthDay(Date: String): IntArray? {

        val parts = Date.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (parts.size == 3) {
            val year: Int = Integer.parseInt(parts[2])
            val month: Int
            val day: Int

            month = Integer.parseInt(parts[1])
            day = Integer.parseInt(parts[0])
            return intArrayOf(year, month, day)
        }
        return null
    }

    fun isOldDate(x: IntArray): Boolean {
        if (Calendar.getInstance().get(Calendar.YEAR) <= x[0])
            if (Calendar.getInstance().get(Calendar.MONTH) + 1 <= x[1])
                return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > x[2]
        return true
    }

    fun permissionNoteDate(dateString: String): String {
        try {
            val formatFrom = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val formatTo = SimpleDateFormat("EEE, dd MMM yyyy, hh:mm aaa", Locale.US)
            val formatTo2 = SimpleDateFormat("EEE, dd MMM yyyy 'at' hh:mm aaa", Locale.US)
            val formatTo3 = SimpleDateFormat("EEE, dd MMM, hh:mm aaa", Locale.US)
            val date = formatFrom.parse(dateString)

            formatTo.format(date)
            formatTo2.format(date)

            return formatTo3.format(date)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getDateFormatFromAnother(dateFormatOne: String, dateFormattow: String, date: String): String? {
        return try {
            val temp = SimpleDateFormat(dateFormatOne, Locale.US).parse(date)
            val sdfDate = SimpleDateFormat(dateFormattow, Locale.US)// dd/MM/yyyy
            sdfDate.format(temp)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }

    }

    private fun removeTime(date: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.set(Calendar.YEAR, 0)
        cal.set(Calendar.MONTH, 0)
        cal.set(Calendar.DAY_OF_YEAR, 0)
        cal.set(Calendar.DAY_OF_WEEK, 0)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.time
    }

    @Throws(DatatypeConfigurationException::class)
    fun removeXMLGregorianCalendarNow(): XMLGregorianCalendar {
        val gregorianCalendar = GregorianCalendar()
        gregorianCalendar.time = removeTime(Date())
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar)
    }

    fun isValid(value: String): Boolean {
        return try {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(value)
            true
        } catch (e: ParseException) {
            false
        }

    }

    fun getDateTimeFormatted(dateString: String): String {
        val timeStamp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        timeStamp.timeZone = TimeZone.getTimeZone("GMT")
        var date: Date? = null
        try {
            date = timeStamp.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val sdfDateOnly = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val sdfDateTime = SimpleDateFormat("HH:mm a", Locale.US)

        return sdfDateOnly.format(date) +
                "\n" +
                sdfDateTime.format(date)
    }

    fun getTimeFormatted(dateString: String): String {
        val timeStamp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        timeStamp.timeZone = TimeZone.getTimeZone("GMT")
        var date: Date? = null
        try {
            date = timeStamp.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val sdfDateTime = SimpleDateFormat("hh:mm a", Locale.US)
        return sdfDateTime.format(date)
    }

    fun getSOQLDateTimeFormatted(calendar: Calendar): String {
        val sdfDateOnly = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US)

        return sdfDateOnly.format(calendar.time)
    }
}
