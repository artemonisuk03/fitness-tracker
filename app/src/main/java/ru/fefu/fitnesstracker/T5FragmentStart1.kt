package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import java.util.*
import kotlin.random.Random

class T5FragmentStart1 : Fragment() {
    private lateinit var adapter: T5AdapterSportsType
    private var selectedSport: String? = null
    private lateinit var viewModel: T6ActivityViewModel

    companion object {
        fun newInstance(): T5FragmentStart1 {
            return T5FragmentStart1()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.t5_fragment_start_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = T6AppDatabase.getDatabase(requireContext())
        val repository = T6Repository(database.activityDao())
        viewModel = ViewModelProvider(this, T6ActivityViewModel.Factory(repository))
            .get(T6ActivityViewModel::class.java)

        val sportsList = listOf(
            T5AdapterSportsType.SportItem("Велосипед", R.drawable.bike),
            T5AdapterSportsType.SportItem("Бег", R.drawable.run),
            T5AdapterSportsType.SportItem("Шаг", R.drawable.walk)
        )

        adapter = T5AdapterSportsType(sportsList).apply {
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
                val activityType = when (sportType) {
                    "Велосипед" -> T6ActivityEntity.ActivityType.BIKING
                    "Бег" -> T6ActivityEntity.ActivityType.RUNNING
                    "Шаг" -> T6ActivityEntity.ActivityType.WALKING
                    else -> T6ActivityEntity.ActivityType.WALKING
                }

                val startTime = Date()
                val endTime =
                    Date(startTime.time + (30 + Random.Default.nextInt(120)) * 60 * 1000) // 30-150 минут
                val distance = Random.nextDouble(1.0, 20.0)

                val activity = T6ActivityEntity(
                    type = activityType,
                    startTime = startTime,
                    endTime = endTime,
                    distance = distance
                )

                viewModel.insert(activity)

                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.activitySelector,
                        T5FragmentStart2.newInstance(
                            sportType,
                            distance,
                            startTime.time,
                            endTime.time
                        )
                    )
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