package ru.fefu.fitnesstracker

import androidx.room.TypeConverter
import java.util.*

class T6Converters {

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millis: Long?): Date? {
        return millis?.let { Date(it) }
    }
}