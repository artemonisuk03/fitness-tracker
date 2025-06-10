package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment() {
    companion object {
        fun newInstance() = FragmentProfile()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.t3_fragment_profile, container, false)
        val exitButton = layoutView.findViewById<Button>(R.id.exitButton)
        val saveButton = layoutView.findViewById<Button>(R.id.saveButton)
        val passButton = layoutView.findViewById<TextView>(R.id.passButton)

        passButton.setOnClickListener {
            navigateToChangePassword()
        }

        saveButton.setOnClickListener {
            (requireActivity() as t3ActivityEmptystate).apply {
                bottomNav.selectedItemId = R.id.nav_activity
                clearBackStackAndShow(FragmentSports.newInstance(), FragmentSportsTag)
            }
        }

        exitButton.setOnClickListener {
            val intent = Intent(requireActivity(), t2ActivityMain::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish()
        }
        return layoutView
    }

    private fun navigateToChangePassword() {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, FragmentChangePassword.newInstance())
            addToBackStack("profile_to_password")
            commit()
        }
    }
}