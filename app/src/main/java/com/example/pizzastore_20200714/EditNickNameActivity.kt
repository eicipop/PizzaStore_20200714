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

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        editNickNameBtn.setOnClickListener {
        var inputNick = nickNameEdt.text.toString()
            val myIntent = Intent()

            myIntent.putExtra("nickname", inputNick)
            setResult(Activity.RESULT_OK, myIntent)
            Toast.makeText(this, inputNick, Toast.LENGTH_SHORT).show()

            finish()
        }
    }

    override fun setValues() {

    }
}