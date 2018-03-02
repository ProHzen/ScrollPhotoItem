package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 16:36
 * Email:  369013520@qq.com
 */
data class ForecastResult(val date: String,
                          val message: String,
                          val status: Int,
                          val city: String,
                          val count: Int,
                          val data: ForecastData) {
}
