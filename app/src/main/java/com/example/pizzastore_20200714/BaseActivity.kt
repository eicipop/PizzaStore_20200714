package com.example.pizzastore_20200714

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    val mContext = this
    abstract fun setupEvents() //이벤트세팅
    abstract fun setValues()  //데이터세팅
}