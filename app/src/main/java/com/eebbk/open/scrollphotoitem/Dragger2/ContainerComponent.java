package com.eebbk.open.scrollphotoitem.Dragger2;

import dagger.Component;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 9:59
 * Email:  369013520@qq.com
 */

@Component(dependencies  = ActivityComponent.class, modules = ContainerModule.class)
public interface ContainerComponent {
    void inject(DraggerActivity draggerActivity);
}
