package com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/9 10:35
 * Email:  369013520@qq.com
 */

import android.content.Context;
import android.widget.TextView;

public class ModeChangeManager {

    private Context mContext;
    private ScrollLinearLayout mScrollLinearLayout;

    public static final int LAPSE_TIME_INDEX = 0;
    public static final int SLOW_MOTION_INDEX = 1;
    public static final int VIDEO_INDEX = 2;
    public static final int PHOTO_INDEX = 3;
    public static final int SQUARE_INDEX = 4;
    public static final int PANORAMA_INDEX = 5;

    private TextView mTvLapseTime;
    private TextView mTvSlowMotion;
    private TextView mTvVideo;
    private TextView mTvPhoto;
    private TextView mTvSquare;
    private TextView mTvPanorama;

    public ModeChangeManager(Context context) {
        mContext = context;
        initView();
    }

    public void setScrollLinearLayout(ScrollLinearLayout mScrollLinearLayout) {
        this.mScrollLinearLayout = mScrollLinearLayout;
    }

    private void initView() {
//        mTvLapseTime = mContext.findViewById(R.id.tv_lapse_time);
    }

}
