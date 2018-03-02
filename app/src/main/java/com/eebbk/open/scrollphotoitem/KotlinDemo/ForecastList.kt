package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 17:10
 * Email:  369013520@qq.com
 */
data class ForecastList(val date: String, val city: String, val forecastList: List<ForecastDayDetail>) {
}