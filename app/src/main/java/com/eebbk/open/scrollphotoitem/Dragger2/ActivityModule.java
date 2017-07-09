package com.eebbk.open.scrollphotoitem.Dragger2;

import dagger.Module;
import dagger.Provides;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 9:04
 * Email:  369013520@qq.com
 */

@Module
public class ActivityModule {

    @Provides
    UserModel providerUserModule() {
        return new UserModel();
    }
}
