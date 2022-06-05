package com.example.autoservice.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.autoservice.fragments.intro.IntroTabItemFragment
import com.example.autoservice.models.IntroTabInfo

class IntroTabAdapter(fragment: Fragment, var tabList:ArrayList<IntroTabInfo>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return tabList.size
    }

    override fun createFragment(position: Int): Fragment {
        val introTabInfo = tabList[position]
        return IntroTabItemFragment.newInstance(introTabInfo)
    }
}