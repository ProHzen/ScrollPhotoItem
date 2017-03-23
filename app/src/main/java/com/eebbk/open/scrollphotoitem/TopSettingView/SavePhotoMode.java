package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/22 8:45
 * Email:  369013520@qq.com
 */

public class SavePhotoMode implements ISettingData {

    private List<String> mSavePhotoModeList = new ArrayList<>();

    public SavePhotoMode() {
        mSavePhotoModeList.add("正常保存");
        mSavePhotoModeList.add("翻转保存");
    }

    @Override
    public List<String> getData() {
        return mSavePhotoModeList;
    }

    @Override
    public int getImageId() {
        return R.drawable.save_style;
    }

    @Override
    public void onClickListener(View view, int i) {

    }
}
