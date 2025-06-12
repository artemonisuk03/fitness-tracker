package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class T3FragmentUsers : Fragment() {
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = T3FragmentUsers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t3_fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.activityRecycler)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            ActivityItemUsers.Header("Вчера"),
            UserActivitiesData.activities[0],
            UserActivitiesData.activities[1],
            ActivityItemUsers.Header("Сегодня"),
            UserActivitiesData.activities[2]
        )

        recyclerView.adapter = T4AdapterUsers(items) { activityId ->
            val fragment = T4FragmentSportsDetailUsers.newInstance(activityId.toInt())
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}