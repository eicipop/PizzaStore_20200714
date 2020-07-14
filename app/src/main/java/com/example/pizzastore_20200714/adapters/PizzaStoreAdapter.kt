package com.example.pizzastore_20200714.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pizzastore_20200714.R
import com.example.pizzastore_20200714.datas.PizzaStore
import com.example.pizzastore_20200714.fragments.FirstFragment
import com.example.pizzastore_20200714.fragments.SecondFragment

class PizzaStoreAdapter(val mContext: Context, val resId: Int, val mList: List<PizzaStore>) :
    ArrayAdapter<PizzaStore>(mContext, resId, mList) {
    //화면 그려줄 때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        // 받아본 임시 row 가 null 인가?
        if(tempRow == null){
            // 만약 null이라면, inf를 이용해서  tempRow를 채워주자
            tempRow = inf.inflate(R.layout.activity_list_item, null)
        }
        val row = tempRow!!
        return row
    }

}