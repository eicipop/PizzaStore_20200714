package com.example.pizzastore_20200714

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizzastore_20200714.adapters.MainViewPagerAdapter
import com.example.pizzastore_20200714.adapters.PizzaStoreAdapter
import kotlinx.android.synthetic.main.activity_first_fragment.*
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second_fragment.*
import kotlinx.android.synthetic.main.activity_view_pizza_store_detail.*

class MainActivity : BaseActivity() {


    lateinit var mvpa : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액션바 숨기기
        var actionBar : androidx.appcompat.app.ActionBar?
        actionBar = supportActionBar
        actionBar?.hide()

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