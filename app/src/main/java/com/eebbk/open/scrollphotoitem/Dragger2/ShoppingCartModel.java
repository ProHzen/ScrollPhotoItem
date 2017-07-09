package com.eebbk.open.scrollphotoitem.Dragger2;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 9:54
 * Email:  369013520@qq.com
 */

public class ShoppingCartModel {

    private String name;
    private String location;

    public ShoppingCartModel() {
        name = "shop";
        location = "JiMei";
    }

    public String getName() {
        return name;
    }

    public ShoppingCartModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ShoppingCartModel setLocation(String location) {
        this.location = location;
        return this;
    }
}
