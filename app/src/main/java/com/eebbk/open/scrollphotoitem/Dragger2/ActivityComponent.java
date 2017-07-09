package com.eebbk.open.scrollphotoitem.Dragger2;

import com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout.MainActivity;

import dagger.Component;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 9:06
 * Email:  369013520@qq.com
 */

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
//    void inject(DraggerActivity draggerActivity);
    UserModel userModel();
}
