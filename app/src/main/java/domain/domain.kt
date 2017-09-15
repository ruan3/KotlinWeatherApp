package domain

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
public class domain {

    data class dataCallback(val result: List<data.Weather01>, val msg:String, val retCode:String)
    data class Weather01(val airCondition:String,val city:String,val coldIndex:String,val date:String,
                         val distrct:String,val dressingIndex:String,val exerciseIndex:String,val future:List<Future>,
                         val humidity:String,val pollutionIndex:String,val province:String,val sunrise:String,
                         val sunset:String,val temperature:String,val time:String,val updateTime:String,val washIndex:String,
                         val weather:String,val week:String,val wind:String)
    data class Future(val date:String,val dayTime:String,val night:String,val temperature:String,val week:String,val wind:String)

}