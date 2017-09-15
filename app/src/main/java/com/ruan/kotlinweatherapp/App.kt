package com.ruan.kotlinweatherapp

import android.app.Application

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/15
 * Description:
 */
class App: Application() {

    companion object {
        private var instance:Application? = null
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}