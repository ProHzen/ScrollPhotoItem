package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 19:29
 * Email:  369013520@qq.com
 */

public class TestMode implements ISettingData {

    private List<String> mList = new ArrayList<>();

    public TestMode(List<String> list) {
        mList = list;
    }

    @Override
    public List<String> getData() {
        return mList;
    }

    @Override
    public int getImageId() {
        return R.drawable.picture_shape;
    }

    @Override
    public void onClickListener(View view, int i) {
        Log.i("TestMode_ysz", " TestMode i = " + i);
    }
}
