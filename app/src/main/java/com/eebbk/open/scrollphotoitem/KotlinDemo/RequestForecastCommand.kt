package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 17:43
 * Email:  369013520@qq.com
 */
class RequestForecastCommand(val url: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecast = Request(url)
        return ForecastDataMapper().convertFromDataModel(forecast.execute())
    }
}