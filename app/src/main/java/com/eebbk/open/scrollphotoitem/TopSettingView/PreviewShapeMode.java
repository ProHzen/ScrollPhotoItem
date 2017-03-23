package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 16:12
 * Email:  369013520@qq.com
 */

public class PreviewShapeMode implements ISettingData {

    private List<String> mPreviewShapeModeList = new ArrayList<>();

    public PreviewShapeMode() {
        mPreviewShapeModeList.add("标准");
        mPreviewShapeModeList.add("方形");
        mPreviewShapeModeList.add("全屏");
    }

    @Override
    public List<String> getData() {
        return mPreviewShapeModeList;
    }

    @Override
    public int getImageId() {
        return R.drawable.picture_shape;
    }

    @Override
    public void onClickListener(View view, int i) {
        Log.i("PreviewShapeMode_ysz", " PreviewShapeMode i = " + i);
    }
}
