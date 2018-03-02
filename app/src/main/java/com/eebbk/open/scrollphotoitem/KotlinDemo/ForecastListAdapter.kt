package com.eebbk.open.scrollphotoitem.KotlinDemo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 14:11
 * Email:  369013520@qq.com
 */
class ForecastListAdapter(val items: List<String>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView) {

    }

}