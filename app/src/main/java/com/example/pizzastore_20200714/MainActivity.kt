package com.example.pizzastore_20200714

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizzastore_20200714.adapters.PizzaStoreAdapter
import com.example.pizzastore_20200714.datas.PizzaStore
import kotlinx.android.synthetic.main.activity_list_item.*

class MainActivity : BaseActivity() {

    val mStoreList = ArrayList<PizzaStore>()
    lateinit var mAdapter: PizzaStoreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
        // 미뤄둔 어댑터 객체화를 실행
        mAdapter = PizzaStoreAdapter(this, R.layout.room_list_item, mRoomList)
        // 완성된 어댑터를 리스트뷰와 연결
        roomListView.adapter = mAdapter
    }
    override fun setupEvents() {

    }

    override fun setValues() {
        val imgUrl =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg/250px-170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg"
        Glide.with(mContext).load(imgUrl).into(imgUrlImageView)
    }
}