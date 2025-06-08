package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class t4FragmentSportsDetail : Fragment() {
    companion object {
        private const val ARG_ACTIVITY_ID = "activity_id"

        fun newInstance(activityId: Long) = t4FragmentSportsDetail().apply {
            arguments = Bundle().apply {
                putLong(ARG_ACTIVITY_ID, activityId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.t3_fragment_sports_detail, container, false)
        val backButton = layoutView.findViewById<Button>(R.id.imageBackarr)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return layoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityId = arguments?.getLong(ARG_ACTIVITY_ID) ?: -1L

        view.findViewById<TextView>(R.id.activityTypeText).text = when (activityId) {
            1L -> "Серфинг"
            2L -> "Велосипед"
            3L -> "Бег"
            else -> "Активность"
        }

        view.findViewById<TextView>(R.id.distanceText).text = when (activityId) {
            1L -> "14.32 км"
            2L -> "1000 м"
            3L -> "5.2 км"
            else -> ""
        }

        view.findViewById<TextView>(R.id.timeAgoText).text = when (activityId) {
            1L -> "14 часов назад"
            2L -> "29.05.2022"
            3L -> "10 часов назад"
            else -> ""
        }

        view.findViewById<TextView>(R.id.durationText).text = when (activityId) {
            1L -> "2 часа 46 минут"
            2L -> "60 минут"
            3L -> "30 минут"
            else -> ""
        }
    }
}