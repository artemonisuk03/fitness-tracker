package ru.fefu.fitnesstracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class t3ActivityEmptystate : AppCompatActivity() {
    internal lateinit var bottomNav: BottomNavigationView
    internal val FragmentSportsTag = "ACTIVITY_FRAGMENT"
    private val fragmentProfileTag = "PROFILE_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t2_activity_emptystate)

        bottomNav = findViewById(R.id.bottom_nav)

        if (savedInstanceState == null) {
            clearBackStackAndShow(FragmentSports.newInstance(), FragmentSportsTag)
        }

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_activity -> {
                    clearBackStackAndShow(FragmentSports.newInstance(), FragmentSportsTag)
                    true
                }
                R.id.nav_profile -> {
                    clearBackStackAndShow(FragmentProfile.newInstance(), fragmentProfileTag)
                    true
                }
                else -> false
            }
        }
    }

    internal fun clearBackStackAndShow(fragment: Fragment, tag: String) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .commit()
    }
}