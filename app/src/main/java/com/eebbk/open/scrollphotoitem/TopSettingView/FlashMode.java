package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 19:51
 * Email:  369013520@qq.com
 */

public class FlashMode implements ISettingData {

    private List<String> mFlashModeList = new ArrayList<>();

    public FlashMode() {
        mFlashModeList.add("关闭");
        mFlashModeList.add("打开");
        mFlashModeList.add("自动");
    }

    @Override
    public List<String> getData() {
        return mFlashModeList;
    }

    @Override
    public int getImageId() {
        return R.drawable.ic_flash_auto_holo_light_edit;
    }

    @Override
    public void onClickListener(View view, int i) {
        Log.i("FlashMode_ysz", " CountDownMode i = " + i);
    }
}
