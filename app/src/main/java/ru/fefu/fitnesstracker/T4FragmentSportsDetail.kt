package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class T4FragmentSportsDetail : Fragment() {
    private lateinit var viewModel: T6ActivityViewModel

    companion object {
        private const val ARG_ACTIVITY_ID = "activity_id"

        fun newInstance(activityId: Int) = T4FragmentSportsDetail().apply {
            arguments = Bundle().apply {
                putInt(ARG_ACTIVITY_ID, activityId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.t4_fragment_sports_detail, container, false)
        val backButton = layoutView.findViewById<Button>(R.id.imageBackarr)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val database = T6AppDatabase.getDatabase(requireContext())
        val repository = T6Repository(database.activityDao())
        viewModel = ViewModelProvider(this, T6ActivityViewModel.Factory(repository))
            .get(T6ActivityViewModel::class.java)

        return layoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityId = arguments?.getInt(ARG_ACTIVITY_ID) ?: -1
        if (activityId == -1) return

        lifecycleScope.launch {
            val activity = viewModel.getActivityById(activityId)
            activity?.let { updateUI(view, activity) }
        }
    }

    private fun updateUI(view: View, activity: T6ActivityEntity) {
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        val durationMinutes = (activity.endTime.time - activity.startTime.time) / (60 * 1000)
        val hours = durationMinutes / 60
        val minutes = durationMinutes % 60

        view.findViewById<TextView>(R.id.activityTypeText).text = when (activity.type) {
            T6ActivityEntity.ActivityType.BIKING -> "Велосипед"
            T6ActivityEntity.ActivityType.RUNNING -> "Бег"
            T6ActivityEntity.ActivityType.WALKING -> "Шаг"
        }

        view.findViewById<TextView>(R.id.distanceText).text =
            String.format("%.2f км", activity.distance)

        view.findViewById<TextView>(R.id.timeAgoText).text =
            dateFormat.format(activity.startTime)

        view.findViewById<TextView>(R.id.durationText).text = if (hours > 0) {
            "$hours ч ${minutes} мин"
        } else {
            "$minutes мин"
        }
    }
}