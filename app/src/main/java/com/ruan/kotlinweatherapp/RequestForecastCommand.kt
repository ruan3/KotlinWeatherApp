package com.ruan.kotlinweatherapp

import data.dataCallback
import domain.Command
import domain.ForecastDataMapper

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
class RequestForecastCommand(val url:String) : Command<dataCallback> {
    override fun execute(): dataCallback {

        val request = Request(url)
        return ForecastDataMapper().convertFromDataModel(request.execute())

    }

}