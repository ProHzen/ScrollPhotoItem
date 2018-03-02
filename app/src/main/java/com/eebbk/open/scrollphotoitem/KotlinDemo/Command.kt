package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 16:59
 * Email:  369013520@qq.com
 */
public interface Command<T> {
    fun execute(): T
}