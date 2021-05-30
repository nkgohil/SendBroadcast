package com.thesevenitsolutions.viewpager

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.thesevenitsolutions.sendbroadcast.R
import kotlinx.android.synthetic.main.activity_viewpager.*

class ViewpagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        tabView()
    }
    private fun tabView() {
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Basic"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Advance"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = TabAdapter(
                supportFragmentManager,
                tabLayout!!.tabCount
        )
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(
                        tabLayout
                )
        )
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d(ContentValues.TAG, "onTabSelected:tabselected")
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                Log.d(ContentValues.TAG, "onTabSelected:tabnotselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}