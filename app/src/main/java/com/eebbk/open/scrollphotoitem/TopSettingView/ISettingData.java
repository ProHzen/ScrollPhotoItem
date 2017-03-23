package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.view.View;

import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 11:28
 * Email:  369013520@qq.com
 */

public interface ISettingData {

    List<String> getData();
    int getImageId();
    void onClickListener(View view, int i);
}
