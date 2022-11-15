package com.jitusolution.week8materialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fragments:ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Branch: Week 9 Start
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragments.add(HomeFragment())
        fragments.add(PlaylistFragment())
        fragments.add(ProfileFragment())

        val adapter = MyAdapter(this, fragments)
        viewpager.adapter = adapter

        viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.selectedItemId = bottomNav.menu.getItem(position).itemId
            }
        })

        bottomNav.setOnItemSelectedListener {
            viewpager.currentItem  = when(it.itemId) {
                R.id.itemHome -> 0
                R.id.itemPlaylist -> 1
                R.id.itemProfile -> 2
                else -> 0
            }

            true
        }
    }
}