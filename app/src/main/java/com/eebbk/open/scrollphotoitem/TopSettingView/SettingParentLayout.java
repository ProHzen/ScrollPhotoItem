package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 14:56
 * Email:  369013520@qq.com
 */

public class SettingParentLayout extends LinearLayout implements SettingLayout.onChildClickListener {

    private int mRow = 3;
    private Context mContext;
    private List<ISettingData> mISettingMode = new ArrayList<>();
    private List<SettingLayout> mSettingLayoutList = new ArrayList<>();

    public SettingParentLayout(Context context) {
        super(context);
        mContext = context;
//        initSettingParent();
    }

    public SettingParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSettingParent();
    }

    public SettingParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSettingParent();
    }

    public SettingParentLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initSettingParent();
    }

    private void initSettingParent() {
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = (int) getResources().getDimension(R.dimen._3px);
        layoutParams.height = (int) getResources().getDimension(R.dimen._107px);
        for (int i = 0; i < mISettingMode.size(); i++) {
            Log.i("SettingParentLayout", " i = " + i);
            SettingLayout child = new SettingLayout(mContext);
            child.setLayoutParams(layoutParams);
            child.setGravity(Gravity.CENTER_VERTICAL);
            child.setPadding(0, 0, (int) getResources().getDimension(R.dimen._45px), 0);
            child.setISettingData(mISettingMode.get(i));
            child.setOnClickListener(mISettingMode.get(i));
            child.setOnChildClickListener(this);
            addView(child);
            mSettingLayoutList.add(child);
        }
    }

    public void setRow(int row) {
        mRow = row;
    }

    public int getModeSize() {
        return mISettingMode.size();
    }

    public void setModeList(List<ISettingData> settingModeList) {
        mISettingMode.clear();
        mISettingMode.addAll(settingModeList);
        initSettingParent();
    }

    public List<SettingLayout> getSettingLayoutList() {
        return mSettingLayoutList;
    }

    public void addMode(ISettingData mode) {
        mISettingMode.add(mode);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = (int) getResources().getDimension(R.dimen._3px);
        layoutParams.height = (int) getResources().getDimension(R.dimen._107px);
        SettingLayout child = new SettingLayout(mContext);
        child.setLayoutParams(layoutParams);
        child.setGravity(Gravity.CENTER_VERTICAL);
        child.setPadding(0, 0, (int) getResources().getDimension(R.dimen._45px), 0);
        child.setISettingData(mode);
        child.setOnClickListener(mode);
        child.setOnChildClickListener(this);
        addView(child);
        mSettingLayoutList.add(child);
    }

    public void refresh() {
        initSettingParent();
    }

    @Override
    public void onClick() {
        // TODO: 2017/2/20  setAnimationDissmiss();
        Log.i("SettingParentLayout_ysz", " child layout click");
    }

    public void show() {
        setVisibility(View.VISIBLE);
    }

    public void dismiss() {
        setVisibility(View.GONE);
    }

}
