package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class T3FragmentMine : Fragment() {
    private lateinit var activityRecycler: RecyclerView
    private lateinit var viewModel: T6ActivityViewModel

    companion object {
        fun newInstance() = T3FragmentMine()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t3_fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = T6AppDatabase.getDatabase(requireContext())
        val repository = T6Repository(database.activityDao())
        viewModel = ViewModelProvider(this, T6ActivityViewModel.Factory(repository))
            .get(T6ActivityViewModel::class.java)

        activityRecycler = view.findViewById(R.id.activityRecycler)
        activityRecycler.layoutManager = LinearLayoutManager(context)

        viewModel.allActivities.observe(viewLifecycleOwner) { activities ->
            val items = mutableListOf<ActivityItem>()
            val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            val groupedActivities = activities.groupBy {
                dateFormat.format(it.startTime)
            }

            groupedActivities.forEach { (date, activitiesForDate) ->
                items.add(ActivityItem.Header(date))

                activitiesForDate.forEach { activity ->
                    val duration = (activity.endTime.time - activity.startTime.time) / (60 * 1000)
                    val hours = duration / 60
                    val minutes = duration % 60

                    items.add(ActivityItem.Activity(
                        id = activity.id,
                        type = when (activity.type) {
                            T6ActivityEntity.ActivityType.BIKING -> "Велосипед"
                            T6ActivityEntity.ActivityType.RUNNING -> "Бег"
                            T6ActivityEntity.ActivityType.WALKING -> "Шаг"
                        },
                        distance = String.format("%.2f км", activity.distance),
                        duration = if (hours > 0) {
                            "$hours ч ${minutes} мин"
                        } else {
                            "$minutes мин"
                        },
                        timeAgo = timeFormat.format(activity.startTime)
                    ))
                }
            }

            activityRecycler.adapter = T4AdapterMine(items) { activityId ->
                val fragment = T4FragmentSportsDetail.newInstance(activityId)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}