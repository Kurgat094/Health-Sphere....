package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager

class MainSlide : AppCompatActivity() {
    private lateinit var mSlideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_slide)

        mSlideViewPager = findViewById(R.id.slideViewpager)
        val backBtn: Button = findViewById(R.id.backbtn)
        val nextBtn: Button = findViewById(R.id.nextbtn)
        val skipBtn: Button = findViewById(R.id.skipButton)
        mDotLayout = findViewById(R.id.indicator_layout)

        skipBtn.setOnClickListener{
            val infoIntent: Intent = Intent(this, SignIn::class.java)
            startActivity(infoIntent)
        }

        val viewPagerAdapter = ViewPagerAdapter(this)
        mSlideViewPager.adapter = viewPagerAdapter

        // Set up the initial dot indicators
        setUpIndicator(0)

        mSlideViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                setUpIndicator(position)
                backBtn.visibility = if (position > 0) View.VISIBLE else View.INVISIBLE
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })

        nextBtn.setOnClickListener {
            if (getItem(0) < (mSlideViewPager.adapter?.count?.minus(1) ?: 0)) {
                mSlideViewPager.setCurrentItem(getItem(1), true)
            } else {
                val Intent0: Intent = Intent(this, SignIn::class.java)
                startActivity(Intent0)

            }
        }

        backBtn.setOnClickListener {
            if (getItem(0) > 0) {
                mSlideViewPager.setCurrentItem(getItem(-1), true)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getItem(i: Int): Int {
        return mSlideViewPager.currentItem + i
    }

    private fun setUpIndicator(position: Int) {
        val dotsCount = mSlideViewPager.adapter?.count ?: 0
        val dots = arrayOfNulls<TextView>(dotsCount)
        mDotLayout.removeAllViews()

        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]?.text = Html.fromHtml("&#8226;")
            dots[i]?.textSize = 35f
            dots[i]?.setTextColor(resources.getColor(R.color.inactive, theme))
            mDotLayout.addView(dots[i])
        }

        if (dots.isNotEmpty()) {
            dots[position]?.setTextColor(resources.getColor(R.color.active, theme))
        }
    }
}
