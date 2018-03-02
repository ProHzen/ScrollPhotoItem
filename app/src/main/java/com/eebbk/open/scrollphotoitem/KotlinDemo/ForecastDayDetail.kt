package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 16:47
 * Email:  369013520@qq.com
 */
data class ForecastDayDetail(val date: String,
                             val sunrise: String,
                             val high: String,
                             val low: String,
                             val sunset: String,
                             val aqi: Float,
                             val fx: String,
                             val type: String,
                             val notice: String) {
}