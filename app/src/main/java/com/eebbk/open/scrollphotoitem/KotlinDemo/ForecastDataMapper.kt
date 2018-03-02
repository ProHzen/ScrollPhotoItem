package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 17:05
 * Email:  369013520@qq.com
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.date, forecast.city, convertForecastListToDomain(forecast.data))
    }

    fun convertForecastListToDomain(data: ForecastData): List<ForecastDayDetail>{
        return data.forecast;
    }
}