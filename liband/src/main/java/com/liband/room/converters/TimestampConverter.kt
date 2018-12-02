package com.liband.room.converters


import androidx.room.TypeConverter
import java.text.DateFormat
import java.text.ParseException
import java.util.*


object TimestampConverter {

    @TypeConverter
    fun fromTimestamp(dateFormat: DateFormat, value: String?): Date? {
        if (value != null) {
            try {
                return dateFormat.parse(value)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return null
        } else {
            return null
        }
    }

    @TypeConverter
    fun dateToTimestamp(dateFormat: DateFormat, value: Date?): String? {

        return if (value == null) null else dateFormat.format(value)
    }
}
