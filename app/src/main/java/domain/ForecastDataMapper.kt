package domain

import data.Weather01
import data.dataCallback

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: dataCallback): dataCallback {
        return dataCallback(convertForecastListTODomain(forecast.result),forecast.msg,forecast.retCode)

    }

    fun convertForecastItemToDomain(it: Weather01):Weather01 {

        return Weather01(it.airCondition,it.city,it.coldIndex,it.date,it.distrct,it.dressingIndex,it.exerciseIndex,
                it.future,it.humidity,it.pollutionIndex,it.province,it.sunrise,it.sunset,it.temperature,
                it.time,it.updateTime,it.washIndex,it.weather,it.week,it.wind)

    }

    fun convertForecastListTODomain(list:List<Weather01>):List<Weather01>{
        return list.map { convertForecastItemToDomain(it) }
    }


}