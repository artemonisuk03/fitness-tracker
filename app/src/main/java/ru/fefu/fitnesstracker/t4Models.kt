package ru.fefu.fitnesstracker

sealed class ActivityItem {
    data class Header(val date: String) : ActivityItem()
    data class Activity(
        val id: Long,
        val type: String,
        val distance: String,
        val duration: String,
        val timeAgo: String,
        val isStarred: Boolean
    ) : ActivityItem()
}