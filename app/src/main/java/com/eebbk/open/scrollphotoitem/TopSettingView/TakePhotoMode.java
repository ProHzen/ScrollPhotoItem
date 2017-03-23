package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 11:41
 * Email:  369013520@qq.com
 */

public class TakePhotoMode implements ISettingData {

    private List<String> mTakePhotoModeList = new ArrayList<>();

    public TakePhotoMode() {
        mTakePhotoModeList.add("普通");
        mTakePhotoModeList.add("触屏");
        mTakePhotoModeList.add("声控");
    }

    @Override
    public List<String> getData() {
        return mTakePhotoModeList;
    }

    @Override
    public int getImageId() {
        return R.drawable.capture_mode;
    }

    @Override
    public void onClickListener(View view, int i) {
        Log.i("TakePhotoMode_ysz", " TakePhotoMode i = " + i);
    }
}
