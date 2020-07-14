package com.example.pizzastore_20200714

import android.os.Bundle
import com.example.pizzastore_20200714.adapters.MainViewPagerAdapter
import com.example.pizzastore_20200714.adapters.PizzaStoreAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    lateinit var mvpa : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

    }

    override fun setValues() {
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mvpa

        mainTabLayout.setupWithViewPager(mainViewPager)
    }

}