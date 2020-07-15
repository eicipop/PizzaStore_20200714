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
    //닉네임을 가지러 간다고 명시하는 숫자를 담은 변수
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
            // 결과를 가지러 이동할 때의 화면 전환
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