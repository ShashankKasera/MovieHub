package com.codeinglogs.persondetails.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.persondetails.ui.fragmet.PersonInfoFragment
import com.codeinglogs.persondetails.ui.fragmet.PersonMoviesFragment
import com.codeinglogs.persondetails.ui.fragmet.PersonPagingFragment

class PersonDetailsViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycal) {
    override fun getItemCount(): Int {
        return  3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PersonInfoFragment()
            1 -> PersonMoviesFragment()
            2 -> PersonPagingFragment()
            else -> Fragment()
        }
    }
}