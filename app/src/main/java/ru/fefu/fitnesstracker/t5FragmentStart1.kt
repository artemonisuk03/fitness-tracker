package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class t5FragmentStart1 : Fragment() {
    companion object {
        fun newInstance(): t5FragmentStart1 {
            return t5FragmentStart1()
        }
    }
    private lateinit var adapter: SportsTypeAdapter
    private var selectedSport: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.t5_fragment_start_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sportsList = listOf(
            SportsTypeAdapter.SportItem("Велосипед", R.drawable.bike),
            SportsTypeAdapter.SportItem("Бег", R.drawable.run),
            SportsTypeAdapter.SportItem("Шаг", R.drawable.walk)
        )

        adapter = SportsTypeAdapter(sportsList).apply {
            onItemSelected = { sport ->
                selectedSport = sport
            }
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.sportsTypes)
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = adapter

        view.findViewById<MaterialButton>(R.id.beginButton).setOnClickListener {
            selectedSport?.let { sportType ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activitySelector, t5FragmentStart2.newInstance(sportType))
                    .addToBackStack(null)
                    .commit()
            } ?: Toast.makeText(
                requireContext(),
                "Выберите вид активности",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}