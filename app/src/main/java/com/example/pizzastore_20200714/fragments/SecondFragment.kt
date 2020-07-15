package com.example.pizzastore_20200714.fragments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzastore_20200714.EditNickNameActivity
import com.example.pizzastore_20200714.R
import kotlinx.android.synthetic.main.activity_second_fragment.*

class SecondFragment : Fragment() {
    val REQ_FOR_NICKNAME = 1000
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeNickBtn.setOnClickListener {
            val resultIntent = Intent(context, EditNickNameActivity::class.java)
            startActivityForResult(resultIntent, REQ_FOR_NICKNAME)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                val newNickName = data?.getStringExtra("nickName")

                nickName.text = newNickName
            }
        }
    }
}