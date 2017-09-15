package com.ruan.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import data.dataCallback

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/13
 * Description:
 */
class ForecastListAdapter(val items: dataCallback) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int = items.result[0].future.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items.result[0].future[position].week+"  温度:"+items.result[0].future[position].temperature
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView:TextView) : RecyclerView.ViewHolder(textView)

}