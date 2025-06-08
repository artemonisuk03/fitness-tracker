package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMine : Fragment() {
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = FragmentMine()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t2_fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            ActivityItem.Header("Вчера"),
            ActivityItem.Activity(
                1,
                "Серфинг",
                "14.32 км",
                "2 часа 46 минут",
                "14 часов назад",
                true
            ),
            ActivityItem.Header("Май 2022 года"),
            ActivityItem.Activity(
                2,
                "Велосипед",
                "1000 м",
                "60 минут",
                "29.05.2022",
                true
            )
        )

        recyclerView.adapter = AdapterMine(items) { activityId ->
            val fragment = t4FragmentSportsDetail.newInstance(activityId)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}