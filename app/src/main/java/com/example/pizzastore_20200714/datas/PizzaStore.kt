package com.example.pizzastore_20200714.datas

import java.io.Serializable

// 데이터를 클래스 통째로 집어 넣기 위해 Serializable 활용
class PizzaStore (val name: String, val url : String, val phoneNum: String, val homepage: String, val appStore: String ) : Serializable{

}