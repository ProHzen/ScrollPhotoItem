package com.eebbk.open.scrollphotoitem.Dragger2;

import dagger.Module;
import dagger.Provides;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 9:58
 * Email:  369013520@qq.com
 */

@Module
public class ContainerModule {

    @Provides
    ShoppingCartModel providerCarModel() {
        return new ShoppingCartModel();
    }
}
