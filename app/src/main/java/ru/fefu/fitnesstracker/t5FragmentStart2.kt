package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class t5FragmentStart2 : Fragment() {

    companion object {
        private const val ARG_SPORT_TYPE = "sport_type"

        fun newInstance(sportType: String) = t5FragmentStart2().apply {
            arguments = Bundle().apply {
                putString(ARG_SPORT_TYPE, sportType)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.t5_fragment_start_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(ARG_SPORT_TYPE)?.let { sportType ->
            view.findViewById<TextView>(R.id.typeText).text = sportType
        }

        view.findViewById<MaterialButton>(R.id.finishButton).setOnClickListener {
            val intent = Intent(requireActivity(), t3ActivityEmptystate::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
            requireActivity().finish()
        }
    }
}