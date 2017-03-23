package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 16:08
 * Email:  369013520@qq.com
 */

public class CountDownMode implements ISettingData {

    private List<String> mCountDownModeList = new ArrayList<>();

    public CountDownMode() {

        mCountDownModeList.add("关闭");
        mCountDownModeList.add("3 秒");
        mCountDownModeList.add("5 秒");
        mCountDownModeList.add("8 秒");
    }

    @Override
    public List<String> getData() {
        return mCountDownModeList;
    }

    @Override
    public int getImageId() {
        return R.drawable.ic_timer_editting;
    }

    @Override
    public void onClickListener(View view, int i) {
        Log.i("CountDownMode_ysz", " CountDownMode i = " + i);
    }
}
