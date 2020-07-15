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
    // 받아오는 피자가게 정보를 담아주기 위한 멤버변수
    // setupEvents / setValuse 등의 함수가 공유하기 편하게 만들기 위해 멤버변수로 저장.
    lateinit var mPizzaStore: PizzaStore
    override fun setupEvents() {
        //전화 주문 버튼을 누르면 실제로 전화 연결하기
        callBtn.setOnClickListener {
            // 안드로이드가 제공하는 화면으로 Intent
            //CALL은 권한처리도 필요함(TedPermission이용)
            //권한 허가 여부에 따른 행동 요령 가이드
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    // 권한 허가가 되어 있는 경우(or 지금 허락해 준 경우)
                    // 안드로이드 전화 CALL 기능 실제 호츌
                    // 어디로 전화걸지 정보 설정
                    val myUri = Uri.parse("tel:${mPizzaStore.phoneNum}")
                    // CALL 액션 인텐트
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    //권한이 최종 거절된 경우 -> 통화 안된다는 안내만.
                    Toast.makeText(mContext, "통화권한이 거부되어 전화를 걸 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            // 실제로 권한 확인 요청
            TedPermission.with(mContext).setPermissions(Manifest.permission.CALL_PHONE)
                .setDeniedMessage("설정에서 통화 권한을 허용해줘야 실행 가능합니다.")
                .setPermissionListener(permissionListener)
                .check()
        }
        homepageBtn.setOnClickListener {
            val myUri = Uri.parse("${mPizzaStore.homepage}") // 실제 인터넷 주소
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
        appStoreUriBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=${mPizzaStore.appStore}") // 실제 앱스토어 주소
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            Toast.makeText(this,mPizzaStore.appStore, Toast.LENGTH_SHORT).show()
            startActivity(myIntent)
            // 액티비티 실행
        }
        messageBtn.setOnClickListener {
            val myUri = Uri.parse("smsto:${mPizzaStore.phoneNum}") // Uri클래스는 android제공으로 자동완성

                val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

            // 액티비티 실행

            myIntent.putExtra("sms_body", myUri)

            startActivity(myIntent)
        }

    }

    override fun setValues() {
        // 멤버변수로 있는 피자가게 변수를 intent 변수에서 받아온 가게로 대입
        mPizzaStore = intent.getSerializableExtra("pizzaStore") as PizzaStore

        // 피자가게 변수를 통해 화면 데이터 세팅
        pizzaStoreNameTxt.text = mPizzaStore.name
        phoneNumTxt.text = mPizzaStore.phoneNum
        homePageUrl.text = mPizzaStore.homepage
        //이미지뷰에 -> 웹이 있는 그림 띄우기 Glide 활용
        val logoUrl = mPizzaStore.url
        Glide.with(mContext).load(logoUrl).into(pizzaStoreLogo)

        val resId = pizzaStoreLogo.resources.getIdentifier(mPizzaStore.url, "drawable", packageName)
        pizzaStoreLogo.setImageResource(resId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_store_detail)
        setupEvents()
        setValues()
    }
}