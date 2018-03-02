package com.eebbk.open.scrollphotoitem.RippleView;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

/**
 * Desc:
 *
 * @author: YangShangZhen
 * @date: 2018/2/28 9:01
 */

public class ChineseWordTv extends TextView {

    private static final int COLOR_P = Color.parseColor("#363636");
    private static final int COLOR_N = Color.parseColor("#ffffff");
    private ValueAnimator mSelectAnimator;
    private ValueAnimator mDisappearAnimator;

    public ChineseWordTv(Context context) {
        super(context);
    }

    public ChineseWordTv(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChineseWordTv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void doSelectAnimation() {
        Log.i("ChineseWordTv", "doSelectAnimation: " + mSelectAnimator);
        if (mSelectAnimator == null) {
            mSelectAnimator =  ValueAnimator.ofObject(new ArgbEvaluator(), COLOR_P, COLOR_N);
            mSelectAnimator.addUpdateListener(animation -> {
                setTextColor((int) animation.getAnimatedValue());
            });
        }
        mSelectAnimator.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.40f,1));
        mSelectAnimator.setDuration(400);
        mSelectAnimator.start();
    }

    public void doDisappearAnimation() {
        Log.i("ChineseWordTv", "doDisappearAnimation: " + mDisappearAnimator);
        if (mDisappearAnimator == null) {
            mDisappearAnimator =  ValueAnimator.ofObject(new ArgbEvaluator(), COLOR_N, COLOR_P);
            mDisappearAnimator.addUpdateListener(animation -> {
                setTextColor((int) animation.getAnimatedValue());
            });
        }
        mSelectAnimator.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.40f,1));
        mSelectAnimator.setDuration(400);
        mDisappearAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mSelectAnimator = null;
        mDisappearAnimator = null;
    }
}
