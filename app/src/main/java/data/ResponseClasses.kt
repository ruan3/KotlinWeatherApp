package data

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
data class Forecast(val date: String, val temp:Temperature, val perssure:String,val humidity:String
                    ,val weather:List<Weather>,val speed:String,val deg:String,val coud:String,val rain:String)
data class ForecastResult(val city:City,val list:List<Forecast>)
data class City(val id:String,val name:String,val coord:CoordInates,val country:String,val population:String)
data class CoordInates(val lon:Float,val lat:Float)
data class Temperature(val day:Float,val min:Float,val max:Float,val night:Float,val eve:Float,val morn:Float)
data class Weather(val id:Long,val main:String,val description:String,val icon:String)