package ru.fefu.fitnesstracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "activities")
data class T6ActivityEntity(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: ActivityType,
    val startTime: Date,
    val endTime: Date,
    val distance: Double
) {
    enum class ActivityType {
        BIKING, RUNNING, WALKING
    }
}