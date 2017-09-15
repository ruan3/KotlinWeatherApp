package com.ruan.kotlinweatherapp

import android.util.Log
import com.google.gson.Gson
import data.dataCallback
import java.net.URL

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
public class Request(val url:String){

    public fun run(){

        val forecastJsonStr = URL(url).readText()
        Log.e(javaClass.simpleName,forecastJsonStr)

    }

    public fun execute():dataCallback {
        val forecastJsonStr = URL(url).readText()
        return Gson().fromJson(forecastJsonStr,dataCallback::class.java)
    }

}