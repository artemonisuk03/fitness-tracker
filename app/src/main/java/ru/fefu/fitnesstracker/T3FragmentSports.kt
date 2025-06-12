package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class T3FragmentSports : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    companion object {
        fun newInstance() = T3FragmentSports()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t3_fragment_sports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        val startButton = view.findViewById<FloatingActionButton>(R.id.startButton)

        setupViewPager()

        startButton.setOnClickListener {
            startActivity(Intent(requireActivity(), T5ActivityStart::class.java))
        }
    }

    private fun setupViewPager() {
        val adapter = T3AdapterSportsPager(this)
        adapter.addFragment(T3FragmentMine.newInstance(), "Мои")
        adapter.addFragment(T3FragmentUsers.newInstance(), "Пользователей")

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}