package com.eebbk.open.scrollphotoitem.KotlinDemo

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 15:32
 * Email:  369013520@qq.com
 */
class Person {
    var name: String = ""

    get() = field.toUpperCase()
    set(value) {
        field = "Name: $value"
    }
}