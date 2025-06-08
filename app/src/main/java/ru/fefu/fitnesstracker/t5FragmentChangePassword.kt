package ru.fefu.fitnesstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentChangePassword : Fragment() {
    companion object {
        fun newInstance() = FragmentChangePassword()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.t4_fragment_change_password, container, false)
        val backButton = layoutView.findViewById<Button>(R.id.imageBackarr)
        val applyBtn = layoutView.findViewById<Button>(R.id.apply)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        applyBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return layoutView
    }
}