package com.ruan.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.ruan.kotlinweatherapp.R.layout
import data.Future
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URLEncoder
import java.util.*

class MainActivity : AppCompatActivity() {


    private val items = listOf(

            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        toast("(｡･∀･)ﾉﾞ嗨，我是kotlin")
        message.text = "我是谁？我来自哪里？？"

//        val ry_forcast_list = findViewById(R.id.ry_forcast_list) as RecyclerView
        val ry_forcast_list : RecyclerView = find(R.id.ry_forcast_list)
        ry_forcast_list.layoutManager = LinearLayoutManager(this)


        async(){
            val text = URLEncoder.encode("广州", "UTF-8")
            val province = URLEncoder.encode("广东","UTF-8")
//            Request("http://apicloud.mob.com/v1/weather/query?key=appkey&city=$text&province=$province").execute
            val result = RequestForecastCommand("http://apicloud.mob.com/v1/weather/query?key=appkey&city=$text&province=$province").execute()
            Log.e("Com",result.toString())
            uiThread{
                longToast("正在请求网络")
//                ry_forcast_list.adapter = ForecastListAdapter(result,object : ForecastListAdapter.OnItemClickListener{
//                    override fun invoke(forecast: Future) {
//
//                        toast(forecast.date)//Anko库函数
//
//                    }
//
//                })
                //简化模式
//                ry_forcast_list.adapter = ForecastListAdapter(result){ forecast->toast(forecast.date)}
                //终极简化模式
                ry_forcast_list.adapter = ForecastListAdapter(result){toast(it.date)}
            }

        }
    }

    fun toast(text:String,long:Int= Toast.LENGTH_SHORT){

        Toast.makeText(this,text,long).show();

    }

}

