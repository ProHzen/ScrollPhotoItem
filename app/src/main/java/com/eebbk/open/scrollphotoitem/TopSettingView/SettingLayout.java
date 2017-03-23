package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/17 11:00
 * Email:  369013520@qq.com
 */

public class SettingLayout extends LinearLayout {

    private List<String> mDatas = new ArrayList<>();
    private int mDataSize;
    private int mImageId;

    private Context mContext;
    private ISettingData mISettingData;

    private int mLogoWidth;
    private int mLogoMarginLeft;
    private int mLogoMarginRight;
    private int mTvPadding = 15;

    private List<TextView> mHolderView = new ArrayList<>();

    private SettingLayout.onChildClickListener mChildListener;

    private int mSelectColorId;
    private int mScreenWidth;

    public SettingLayout(Context context) {
        super(context);
        mContext = context;
//        initSettingLayout(context);
        mSelectColorId = getResources().getColor(R.color.mode_edit_select_textcolor);
    }

    public SettingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSettingLayout(context);
    }

    public SettingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSettingLayout(context);
    }

    public SettingLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initSettingLayout(context);
    }

    private void initSettingLayout(Context context) {

        initDimens();
        initData();

        ImageView imageLogo = new ImageView(context);
        LinearLayout.LayoutParams logoParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        logoParams.width = mLogoWidth;
        logoParams.leftMargin = mLogoMarginLeft;
        logoParams.rightMargin = mLogoMarginRight;

        imageLogo.setLayoutParams(logoParams);
        imageLogo.setScaleType(ImageView.ScaleType.CENTER);
        imageLogo.setImageResource(mImageId);
        addView(imageLogo);

//        LinearLayout.LayoutParams mParam = new LinearLayout.LayoutParams(
//                0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);

        LinearLayout.LayoutParams mParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        for (int i = 0; i < mDatas.size(); i++) {
            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            textView.setText(mDatas.get(i));
            textView.setId(i);
//            setOrderRules(mDataSize, i, textView);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(mParam);
            final int finalI = i;
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mChildListener == null) {
                        Log.i("SettingLayout_ysz", " mChildListener ");
                    }
                    mChildListener.onClick();
                    setTextSelectColor(finalI);
                    mISettingData.onClickListener(v, finalI);
                }
            });
            addView(textView);
            mHolderView.add(textView);
        }
        setBackgroundColor(Color.BLACK);
    }

    private void initData() {
        mDatas.clear();
        mDatas.addAll(mISettingData.getData());
        mDataSize = mDatas.size();
        mImageId = mISettingData.getImageId();
    }

    private void initState() {
        mHolderView.get(0).setTextColor(mSelectColorId);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int width;
        int offset;
        if (mDataSize > 1) {
            width = getChildAt(2).getWidth();
            offset = (mScreenWidth - mLogoWidth - mLogoMarginLeft - mLogoMarginRight
                    - getPaddingRight() - getChildAt(1).getWidth() - width * (mDataSize - 1)) / (mDataSize - 1);
        } else {
            width = getChildAt(1).getWidth();
            offset = (mScreenWidth - mLogoWidth - mLogoMarginLeft - mLogoMarginRight
                    - getPaddingRight() - width * mDataSize) / (mDataSize - 1);
        }

        for (int i = 1; i <= mDataSize; i++) {
            View childView = getChildAt(i);
            childView.layout(childView.getLeft() + (i - 1) * offset,
                    childView.getTop(),
                    childView.getRight() + (i - 1) * offset,
                    childView.getBottom());
        }
    }

    private void setOrderRules(int dataSize, int order, TextView tv) {
        switch (dataSize) {
            case 2:
                if (order == 0) {
                    tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                } else if (order == 1) {
                    tv.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                }
                break;
            case 3:
                if (order == 0) {
                    tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                } else if (order == 2) {
                    tv.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                } else {
                    tv.setGravity(Gravity.CENTER);
                }
                break;
            case 4:
                if (order == 0) {
                    tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                } else if (order == 1) {
                    tv.setPadding(0, 0, mTvPadding, 0);
                    tv.setGravity(Gravity.CENTER);
                } else if (order == 2) {
                    tv.setPadding((int) getResources().getDimension(R.dimen._50px), 0, 0, 0);
                    tv.setGravity(Gravity.CENTER);
//                    tv.setBackgroundColor(Color.YELLOW);
                } else {
                    tv.setPadding(0, 0, 0, 0);
                    tv.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                }
                break;
            default:
                break;
        }
    }

    private void initDimens() {
        mLogoWidth = (int) getResources().getDimension(R.dimen._63px);
        mLogoMarginLeft = (int) getResources().getDimension(R.dimen._48px);
        mLogoMarginRight = (int) getResources().getDimension(R.dimen._93px);

        mScreenWidth = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    public void setOnClickListener(ISettingData mISetting) {
        mISettingData = mISetting;
    }

    public void setISettingData(ISettingData ISettingData) {
        mISettingData = ISettingData;
        initSettingLayout(mContext);
    }

    public List<TextView> getViewHolder() {
        return mHolderView;
    }

    public void setTextSelectColor(int index) {
        for (int i = 0; i < mDataSize; i++) {
            if (i == index) {
                mHolderView.get(i).setTextColor(mSelectColorId);
            } else {
                mHolderView.get(i).setTextColor(Color.WHITE);
            }
        }
    }

    public void setOnChildClickListener(SettingLayout.onChildClickListener mListener) {
        Log.i("SettingLayout_ysz", " setOnChildClickListener ");
        mChildListener = mListener;
    }

    public interface onChildClickListener {
        void onClick();
    }

    public void show() {
        setVisibility(View.VISIBLE);
    }

    public void dismiss() {
        setVisibility(View.GONE);
    }
}
