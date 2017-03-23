package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/21 9:59
 * Email:  369013520@qq.com
 */

public class DrawHoriontalView extends LinearLayout {

    private int mScreenWidth;
    private String[] name = new String[]{"关闭", "3 秒", "5 秒", "8 秒"};

    private int mLogoWidth;
    private int mLogoMarginLeft;
    private int mLogoMarginRight;
    private int mTvPadding = 15;

    private int mTextMarginLeft = 0;
    private int mTextMarginRight = 0;

    public DrawHoriontalView(Context context) {
        super(context);
        initView(context);
    }

    public DrawHoriontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DrawHoriontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public DrawHoriontalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        mScreenWidth = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        initDimens();
        addLogo(R.drawable.capture_mode);
        addIndicator(name);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int width = getChildAt(2).getWidth();
        int offset = (mScreenWidth - mLogoWidth - mLogoMarginLeft - mLogoMarginRight
                - getPaddingRight() - width * name.length) / (name.length - 1);
        for (int i = 1; i <= name.length; i++) {
            View childView = getChildAt(i);
            childView.layout(childView.getLeft() + (i - 1) * offset,
                    childView.getTop(),
                    childView.getRight() + (i - 1) * offset,
                    childView.getBottom());
        }
    }

    public void addIndicator(String[] name) {
        for (int i = 0; i < name.length; i++) {
            TextView mTextView = new TextView(getContext());
            mTextView.setText(name[i]);
            mTextView.setTextColor(Color.WHITE);
            mTextView.setLines(1);
            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.setMargins(mTextMarginLeft, 0, mTextMarginRight, 0);
            final int finalI = i;
            mTextView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            addView(mTextView, ll);
        }
    }

    public void addLogo(int imageId) {
        ImageView imageLogo = new ImageView(getContext());
        LinearLayout.LayoutParams logoParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        logoParams.width = mLogoWidth;
        logoParams.leftMargin = mLogoMarginLeft;
        logoParams.rightMargin = mLogoMarginRight;

        imageLogo.setLayoutParams(logoParams);
        imageLogo.setScaleType(ImageView.ScaleType.CENTER);
        imageLogo.setImageResource(imageId);
        addView(imageLogo);
    }

    private void initDimens() {
        mLogoWidth = (int) getResources().getDimension(R.dimen._63px);
        mLogoMarginLeft = (int) getResources().getDimension(R.dimen._48px);
        mLogoMarginRight = (int) getResources().getDimension(R.dimen._93px);
    }
}
