package com.example.pizzastore_20200714.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.pizzastore_20200714.fragments.FirstFragment
import com.example.pizzastore_20200714.fragments.SecondFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentManager(fm) {
    fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "피자 주문"
            else -> "내 정보 설정"
        }
    }
    fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return FirstFragment()
            }
            else -> {
                return SecondFragment()
            }
        }

        // when + return  결합 특수 형태
        return when(position){
            0-> FirstFragment()
            else -> SecondFragment()
        }

    }

    fun getCount(): Int {
        return 2
    }
}