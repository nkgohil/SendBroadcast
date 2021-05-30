package com.thesevenitsolutions.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.thesevenitsolutions.sendbroadcast.R


class ViewPager2 : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        viewPager = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout1)
        viewPager?.setAdapter(createCardAdapter())
        TabLayoutMediator(tabLayout, viewPager,
            TabConfigurationStrategy { tab, position ->
                tab.text = "Tab " + (position + 1)
            }).attach()
    }

    private fun createCardAdapter(): ViewPager2Adapter {
        return ViewPager2Adapter(this)
    }
}
