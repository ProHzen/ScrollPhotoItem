package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 15:57
 * Email:  369013520@qq.com
 */

public class SettingModeManager {

    private Context mContext;

    private TakePhotoMode mTakePhotoMode;
    private CountDownMode mCountDownMode;
    private PreviewShapeMode mPreviewShapeMode;
    private FlashMode mFlashMode;
    private SavePhotoMode mSavePhotoMode;

    private List<String> mTestList = new ArrayList<>();

    private LinearLayout mLinearLayout;
    private SettingLayout mTakePhotoLayout;
    private SettingLayout mCountDownLayout;
    private SettingLayout mPreviewShapeLayout;
    private SettingLayout mFlashLayout;
    private SettingLayout mSavePhotoModeLayout;

    public static final int INDEX_PHOTO = 0;
    public static final int INDEX_COUNT_DOWN = 1;
    public static final int INDEX_PREVIEW_SHAPE = 2;
    public static final int INDEX_FLASH_MODE = 3;
    public static final int INDEX_SAVE_PHOTO_MODE = 3;

    private SettingParentLayout mSettingParentLayout;

    private List<ISettingData> mSettingDataList = new ArrayList<>();

    public SettingModeManager(Context context, LinearLayout mParent) {
        mContext = context;
        mLinearLayout = mParent;
        initData();
    }

    private void initData() {
        initMode();
        initSettingLayout();
        initState();
    }

    /**
     * 初始化布局状态
     */
    private void initState() {
//        mTakePhotoLayout.setVisibility(View.GONE);
    }

    /**
     * 初始化设置数据
     */
    private void initMode() {
//        mTakePhotoModeList.add("普通");
//        mTakePhotoModeList.add("触屏");
//        mTakePhotoModeList.add("声控");
//
//        mCountDownModeList.add("关闭");
//        mCountDownModeList.add("3 秒");
//        mCountDownModeList.add("5 秒");
//        mCountDownModeList.add("8 秒");
//
//        mPreviewShapeModeList.add("标准");
//        mPreviewShapeModeList.add("方形");
//        mPreviewShapeModeList.add("全屏");
//
//        mFlashModeList.add("关闭");
//        mFlashModeList.add("打开");
//        mFlashModeList.add("自动");
        mTakePhotoMode = new TakePhotoMode();
        mCountDownMode = new CountDownMode();
        mPreviewShapeMode = new PreviewShapeMode();
        mFlashMode = new FlashMode();
        mSavePhotoMode = new SavePhotoMode();

        mSettingDataList.add(mTakePhotoMode);
        mSettingDataList.add(mCountDownMode);
        mSettingDataList.add(mPreviewShapeMode);
        mSettingDataList.add(mFlashMode);
        mSettingDataList.add(mSavePhotoMode);
    }

    /**
     * 初始化设置布局
     */
    private void initSettingLayout() {
        mSettingParentLayout = new SettingParentLayout(mContext);
        mSettingParentLayout.setModeList(mSettingDataList);
        mSettingParentLayout.setRow(mSettingDataList.size());
        mSettingParentLayout.setOrientation(LinearLayout.VERTICAL);
        mLinearLayout.addView(mSettingParentLayout);

        mTakePhotoLayout = mSettingParentLayout.getSettingLayoutList().get(INDEX_PHOTO);
        mCountDownLayout = mSettingParentLayout.getSettingLayoutList().get(INDEX_COUNT_DOWN);
        mPreviewShapeLayout = mSettingParentLayout.getSettingLayoutList().get(INDEX_PREVIEW_SHAPE);
        mFlashLayout = mSettingParentLayout.getSettingLayoutList().get(INDEX_SAVE_PHOTO_MODE);
        mSavePhotoModeLayout = mSettingParentLayout.getSettingLayoutList().get(INDEX_SAVE_PHOTO_MODE);

    }

    public void addLineTwo() {
        mTestList.clear();
        mTestList.add("普通");
        mTestList.add("触屏");
        TestMode mTestMode = new TestMode(mTestList);
        mSettingParentLayout.addMode(mTestMode);
    }

    public void addLineThree() {
        mTestList.clear();
        mTestList.add("普通");
        mTestList.add("触屏");
        mTestList.add("普通");
        TestMode mTestMode = new TestMode(mTestList);
        mSettingParentLayout.addMode(mTestMode);
    }

    public void addLineFour() {
        mTestList.clear();
        mTestList.add("普通");
        mTestList.add("触屏");
        mTestList.add("普通");
        mTestList.add("触屏");
        TestMode mTestMode = new TestMode(mTestList);
        mSettingParentLayout.addMode(mTestMode);
    }

    public SettingLayout getModeLayout(int index) {
        return mSettingParentLayout.getSettingLayoutList().get(index);
    }
}
