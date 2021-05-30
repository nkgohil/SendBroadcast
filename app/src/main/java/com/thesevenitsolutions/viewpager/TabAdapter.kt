package com.thesevenitsolutions.viewpager


import androidx.fragment.app.FragmentPagerAdapter


class TabAdapter(
        fm: androidx.fragment.app.FragmentManager,
        private var totalTabs: Int) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return totalTabs
    }



    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return when (p0) {
            0 -> {

                BasicFragment()

            }
            1 -> {
                AdvanceFragment()
            }


            else -> null!!
        }
    }

}
