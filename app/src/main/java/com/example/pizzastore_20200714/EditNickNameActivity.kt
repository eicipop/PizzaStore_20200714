package com.example.pizzastore_20200714

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_nick_name.*
import kotlinx.android.synthetic.main.activity_second_fragment.*

class EditNickNameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        var actionBar : androidx.appcompat.app.ActionBar?
        actionBar = supportActionBar
        actionBar?.hide()

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        editNickNameBtn.setOnClickListener {
            // 입력한 닉네임을 받아야 들고 돌아감
            var inputNick = nickNameEdt.text.toString()
            // 결과로 닉네임 첨부 + OK눌럿다고 명시
            val myIntent = Intent()
            myIntent.putExtra("nickName", inputNick)
            setResult(Activity.RESULT_OK, myIntent)
            //Toast.makeText(this, inputNick, Toast.LENGTH_SHORT).show()

            finish()
        }
    }

    override fun setValues() {

    }
}