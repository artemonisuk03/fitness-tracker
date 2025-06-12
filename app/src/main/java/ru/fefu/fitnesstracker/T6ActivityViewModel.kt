package ru.fefu.fitnesstracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class T6ActivityViewModel(private val repository: T6Repository) : ViewModel() {
    val allActivities: LiveData<List<T6ActivityEntity>> = repository.getAllActivities()

    fun insert(activity: T6ActivityEntity) = viewModelScope.launch {
        repository.insertActivity(activity)
    }

    suspend fun getActivityById(activityId: Int): T6ActivityEntity? {
        return repository.getActivityById(activityId)
    }

    class Factory(private val repository: T6Repository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return T6ActivityViewModel(repository) as T
        }
    }
}