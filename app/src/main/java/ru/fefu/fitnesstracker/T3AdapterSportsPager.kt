package ru.fefu.fitnesstracker

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class T3AdapterSportsPager(fragmentActivity: T3FragmentSports) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    fun getPageTitle(position: Int): String {
        return titles[position]
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}