package data

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
data class dataCallback(val result:List<Weather01>,val msg:String,val retCode:String){
    operator fun get(positon:Int) : Weather01 = result[positon]
    fun size():Int = result.size
}
data class Weather01(val airCondition:String,val city:String,val coldIndex:String,val date:String,
                   val distrct:String,val dressingIndex:String,val exerciseIndex:String,val future:List<Future>,
                     val humidity:String,val pollutionIndex:String,val province:String,val sunrise:String,
                     val sunset:String,val temperature:String,val time:String,val updateTime:String,val washIndex:String,
                     val weather:String,val week:String,val wind:String){
    operator fun get(positon: Int) : Future = future[positon]
    fun size():Int = future.size
}
data class Future(val date:String,val dayTime:String,val night:String,val temperature:String,val week:String,val wind:String)