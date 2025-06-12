package ru.fefu.fitnesstracker

import androidx.lifecycle.LiveData

class T6Repository(private val activityDao: T6ActivityDao) {

    suspend fun insertActivity(activity: T6ActivityEntity) {
        activityDao.insert(activity)
    }

    fun getAllActivities(): LiveData<List<T6ActivityEntity>> {
        return activityDao.getAllActivities()
    }

    suspend fun getActivityById(activityId: Int): T6ActivityEntity? {
        return activityDao.getActivityById(activityId)
    }
}