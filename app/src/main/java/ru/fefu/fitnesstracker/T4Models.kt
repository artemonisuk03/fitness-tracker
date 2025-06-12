package ru.fefu.fitnesstracker

sealed class ActivityItem {
    data class Header(val date: String) : ActivityItem()
    data class Activity(
        val id: Int,
        val type: String,
        val distance: String,
        val duration: String,
        val timeAgo: String
    ) : ActivityItem()
}

sealed class ActivityItemUsers {
    data class Header(val date: String) : ActivityItemUsers()
    data class Activity(
        val id: Int,
        val type: String,
        val distance: String,
        val duration: String,
        val timeAgo: String,
        val userName: String
    ) : ActivityItemUsers()
}

object UserActivitiesData {
    val activities = listOf(
        ActivityItemUsers.Activity(
            1,
            "Бег",
            "5.2 км",
            "30 минут",
            "10 часов назад",
            "@van_darkholme"
        ),
        ActivityItemUsers.Activity(
            2,
            "Велоспорт",
            "15.7 км",
            "45 минут",
            "5 часов назад",
            "@cirno"
        ),
        ActivityItemUsers.Activity(
            3,
            "Плавание",
            "1.2 км",
            "25 минут",
            "1 час назад",
            "@armstrong"
        )
    )
}