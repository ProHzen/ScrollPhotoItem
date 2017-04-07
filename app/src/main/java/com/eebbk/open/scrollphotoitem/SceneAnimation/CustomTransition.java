package com.eebbk.open.scrollphotoitem.SceneAnimation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/3/31 20:47
 * Email:  369013520@qq.com
 */

public class CustomTransition extends Transition {

    private static final String SCAN_HEIGHT = "com.eebbk.open.scrollphotoitem.SceneAnimation:CustomTransition:height";
    private static final String SCAN_WIDTH= "com.eebbk.open.scrollphotoitem.SceneAnimation:CustomTransition:width";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(SCAN_WIDTH, view.getWidth());
        transitionValues.values.put(SCAN_HEIGHT, view.getHeight());
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(SCAN_WIDTH, view.getWidth() / 2);
        transitionValues.values.put(SCAN_HEIGHT, view.getHeight() / 2);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        if (startValues == null || endValues == null) {
            return null;
        }
        final View startView = startValues.view;
        int startWidth = startView.getWidth();
        Log.i("ysz", " startWidth = " + startWidth);
        int startHeight = startView.getHeight();

        final View endView = endValues.view;
        int endWidth = endView.getWidth();
        int endHeight = endView.getHeight();

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ValueAnimator animator = ValueAnimator.ofInt(449, 720);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object value = animation.getAnimatedValue();
                if (value != null) {
                    params.width = (int) value;
                    endView.setLayoutParams(params);
                }
            }
        });
        return animator;
    }
}
