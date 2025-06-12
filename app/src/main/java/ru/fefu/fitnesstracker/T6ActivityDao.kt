package ru.fefu.fitnesstracker

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface T6ActivityDao {

    @Insert
    suspend fun insert(activity: T6ActivityEntity)

    @Query("SELECT * FROM activities ORDER BY startTime DESC")
    fun getAllActivities(): LiveData<List<T6ActivityEntity>>

    @Query("SELECT * FROM activities WHERE id = :activityId")
    suspend fun getActivityById(activityId: Int): T6ActivityEntity?
}