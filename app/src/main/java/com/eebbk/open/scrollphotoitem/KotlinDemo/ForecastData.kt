package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 16:44
 * Email:  369013520@qq.com
 */
data class ForecastData(val shidu: String,
                        val pm25: Float,
                        val pm10: Float,
                        val quality: String,
                        val wendu: String,
                        val ganmao: String,
                        val yesterday: List<ForecastDayDetail>,
                        val forecast: List<ForecastDayDetail>) {
}