package com.ruan.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import data.Future
import data.dataCallback
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * File Name:   天气适配器
 * Author:      ruan
 * Write Dates: 2017/9/13
 * Description: Lambdas表达式实现代码
 */
class ForecastListAdapter(val items: dataCallback,val itemOnclick: (Future)->Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int = items.result[0].size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.bindForecast(items.result[0].future[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
       val view = LayoutInflater.from(parent.cxt).inflate(R.layout.item_forecast,parent,false)
        return  ViewHolder(view,itemOnclick)
    }

    class ViewHolder(view:View,val itemOnclick:(Future)->Unit) : RecyclerView.ViewHolder(view){


//        private val dateView:TextView
//        private val desciptionView:TextView
//        private val temperatureView:TextView
        init{
            //这个直接实例化
//            dateView = view.find(R.id.date)
//            desciptionView = view.find(R.id.description)
//            temperatureView = view.find(R.id.maxTemperature)
        }

        fun bindForecast(future:Future){

            with(future){
                //一个with包含这个对象，直接可以调用对象里面的属性
                /**
                 * with是一个非常有用的函数，它包含在Kotlin的标准库中。它接收一个对象
                和一个扩展函数作为它的参数，然后使这个对象扩展这个函数。这表示所
                有我们在括号中编写的代码都是作为对象（第一个参数） 的一个扩展函
                数，我们可以就像作为this一样使用所有它的public方法和属性。当我们针
                对同一个对象做很多操作的时候这个非常有利于简化代码。
                 */
                itemView.date.text = date //使用kotlin android extensiones 直接访问xml布局文件
//                dateView.text = date //老方式的find
//                desciptionView.text = wind
                itemView.description.text = wind //使用kotlin android extensiones 直接访问xml布局文件
//                temperatureView.text = temperature //老方式的id
                itemView.maxTemperature.text = temperature //使用kotlin android extensiones 直接访问xml布局文件
                itemView.setOnClickListener { itemOnclick(future) }
            }

        }

    }

    public interface OnItemClickListener {
        operator fun invoke(forecast:Future)
    }

}