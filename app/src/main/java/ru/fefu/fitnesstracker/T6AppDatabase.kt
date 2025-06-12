package ru.fefu.fitnesstracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [T6ActivityEntity::class], version = 2)
@TypeConverters(T6Converters::class)
abstract class T6AppDatabase : RoomDatabase() {
    abstract fun activityDao(): T6ActivityDao

    companion object {
        @Volatile
        private var INSTANCE: T6AppDatabase? = null

        fun getDatabase(context: Context): T6AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    T6AppDatabase::class.java,
                    "fitness_tracker_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}