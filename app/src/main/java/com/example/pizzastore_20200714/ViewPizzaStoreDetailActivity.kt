package com.example.pizzastore_20200714

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzastore_20200714.adapters.PizzaStoreAdapter
import com.example.pizzastore_20200714.datas.PizzaStore
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_first_fragment.*
import kotlinx.android.synthetic.main.activity_view_pizza_store_detail.*
import android.Manifest

class ViewPizzaStoreDetailActivity : BaseActivity() {

    override fun setupEvents() {
        callBtn.setOnClickListener {

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    val phoneNumTxt = phoneNumTxt.text.toString()
                    val myUri = Uri.parse("tel:${phoneNumTxt}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "통화권한이 거부되어 전화를 걸 수 없습니다.", Toast.LENGTH_SHORT).show()
                }

            }
            TedPermission.with(mContext).setPermissions(Manifest.permission.CALL_PHONE)
                .setDeniedMessage("설정에서 통화 권한을 허용해줘야 합니다.")
                .setPermissionListener(permissionListener)
                .check()
        }

    }

    override fun setValues() {
        var storeName: PizzaStore = intent.getSerializableExtra("pizzaStore") as PizzaStore
        pizzaStoreNameTxt.text = storeName.name
        phoneNumTxt.text = storeName.phoneNum
        val logoUrl = storeName.url
        Glide.with(mContext).load(logoUrl).into(pizzaStoreLogo)

        val resId = pizzaStoreLogo.resources.getIdentifier(storeName.url, "drawable", packageName)
        pizzaStoreLogo.setImageResource(resId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_store_detail)
        setupEvents()
        setValues()
    }
}