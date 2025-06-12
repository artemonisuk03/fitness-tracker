package ru.fefu.fitnesstracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class T3ActivityEmptystate : AppCompatActivity() {
    internal lateinit var bottomNavMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t3_activity_emptystate)

        bottomNavMenu = findViewById(R.id.bottomNavigation)

        if (savedInstanceState == null) {
            showFragment(T3FragmentSports.newInstance())
        }

        bottomNavMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationActivity -> {
                    showFragment(T3FragmentSports.newInstance())
                    true
                }
                R.id.navigationProfile -> {
                    showFragment(T3FragmentProfile.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    internal fun showFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}