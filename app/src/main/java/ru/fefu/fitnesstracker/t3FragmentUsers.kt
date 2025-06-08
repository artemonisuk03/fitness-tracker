package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentUsers : Fragment() {
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = FragmentUsers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t2_fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            ActivityItem.Header("Вчера"),
            ActivityItem.Activity(
                3,
                "Бег",
                "5.2 км",
                "30 минут",
                "10 часов назад",
                false
            )
        )

        recyclerView.adapter = AdapterUsers(items) { activityId ->
            val fragment = t4FragmentSportsDetail.newInstance(activityId)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}