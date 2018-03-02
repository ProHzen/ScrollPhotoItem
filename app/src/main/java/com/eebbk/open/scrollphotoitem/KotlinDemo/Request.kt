package com.eebbk.open.scrollphotoitem.KotlinDemo

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 15:45
 * Email:  369013520@qq.com
 */
public class Request(val url: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://www.sojson.com/open/api/weather/json.shtml?city=北京"
    }

    public fun run(): String {
        val forecastJsonStr = URL(URL).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return forecastJsonStr
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(URL).readText()
        val forecastResult: ForecastResult = Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
        Log.d("ForecastResult_Request", " forecastJsonStr = " + forecastJsonStr
                + " forecastResult = " + forecastResult.toString());
        return forecastResult
    }
}