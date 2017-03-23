package com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.animation.ObjectAnimator;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/8 10:31
 * Email:  369013520@qq.com
 */

public class ScrollLinearLayout extends LinearLayout {

    public static final String TAG = " ScrollLinearlayout ";
    private Matrix mMatrix;
    private Camera mCamera;
    private Paint mPaint;

    /**
     * 默认的初始位置
     */
    private static final int DEFAULT_CURRENT_ITEM = 1;

    /**
     * 旋转基准角度
     */
    private static final float ROTATE_DEGREE = 9.0f;

    /**
     * 动画持续时间
     */
    private static final int ANIMATION_DURATION_TIME = 250;

    public ModeChangeListener mModeChangeListener;

    private int mCurrenItem = DEFAULT_CURRENT_ITEM;
    private int mCurrentItemCopy;
    private int screenWidth;

    private String[] name = new String[]{"延时摄影", "慢动作", "视频", "拍照", "正方形", "全景"};

    private int mAnimationCount = 0;
    private boolean mRequstLayout = false;
    private boolean mAnimationRunning = false;
    private boolean mScrollRight = false;

    public ScrollLinearLayout(Context context) {
        super(context);
        initView(context);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context mContext) {
        screenWidth = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.i(TAG, " onLayout ");
        View childCurrentView = getChildAt(mCurrenItem);
        int childCurrentViewDelta = getWidth() / 2 - childCurrentView.getLeft() - childCurrentView.getWidth() / 2;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.layout(childView.getLeft() + childCurrentViewDelta, childView.getTop(),
                    childView.getRight() + childCurrentViewDelta, childView.getBottom());
        }

        mRequstLayout = false;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            updateChildItem(canvas, i);
        }
    }
    ObjectAnimator rotateAnimator;
    public void updateChildItem(Canvas mCanvas, int item) {
        View view = getChildAt(item);
        float rotate = Math.abs(item - mCurrenItem) * ROTATE_DEGREE;
        if (item < mCurrenItem) {

//            TextView mChildView = ((TextView)view);
//            Log.i(TAG, " mChildView.getX() = " + mChildView.getX() + " mChildView.getWidth() / 3 = " +mChildView.getWidth() / 3);
//            mChildView.setPivotX(mChildView.getX() + mChildView.getWidth() / 3);
//            mChildView.setScaleX(1 - 0.1f*(Math.abs(item - mCurrenItem)));
//                  ((TextView) view).setRotationY(-rotate);

            ((TextView) view).setScaleX(1 - Math.abs(item - mCurrenItem) * 0.01f);
//            ((TextView) view).setScaleY(1 - Math.abs(item - mCurrenItem) * 0.01f);
            ((TextView) view).setRotationY(-rotate);
            rotateAnimator = ObjectAnimator.ofFloat(((TextView) view), "rotationY", 0.0f, -rotate);
            rotateAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else {
            ((TextView) view).setRotationY(rotate);
            rotateAnimator = ObjectAnimator.ofFloat(((TextView) view), "rotationY", 0.0f, rotate);
            rotateAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }

        drawChild(mCanvas, view, getDrawingTime());
        updateTextColor();
    }

    public void updateTextColor() {
        for (int i = 0; i < getChildCount(); i++) {
            TextView textView = (TextView) getChildAt(i);
            if (i == mCurrenItem) {
                textView.setTextColor(Color.YELLOW);
            } else {
                textView.setTextColor(Color.WHITE);
            }
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
            ll.setMargins(20, 0, 20, 0);
            final int finalI = i;
            mTextView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startTranslate(getCurrentItem(), finalI);
                }
            });
            addView(mTextView, ll);
        }
    }

    public void scrollToLeft() {
        if (mRequstLayout) {
            return;
        }

        if (mCurrenItem < getChildCount() - 1) {
            if (mAnimationRunning) {
                if (mAnimationCount < 1) {
                    mCurrentItemCopy = mCurrenItem + 1;
                    mAnimationCount++;
                    mScrollRight = false;
                }
                return;
            }
            mCurrenItem++;
            startAnimation(mCurrenItem, mCurrenItem - 1);
            updateTextColor();
        }
    }

    public void scrollToRight() {
        if (mRequstLayout) {
            return;
        }

        if (mCurrenItem > 0) {
            if (mAnimationRunning) {
                if (mAnimationCount < 1) {
                    mCurrentItemCopy = mCurrenItem - 1;
                    mAnimationCount++;
                    mScrollRight = true;
                }
                return;
            }
            mCurrenItem--;
            startAnimation(mCurrenItem, mCurrenItem + 1);
            updateTextColor();
        }
    }

    public void startAnimation(final int currenItem, final int last) {
        View currentView = getChildAt(currenItem);
        final int width = currentView.getWidth();
        final int childCount = getChildCount();
        int translate = getWidth() / 2 - currentView.getLeft() - width / 2;
        Log.i(TAG, "startAnimation translate = " + translate);
        for (int i = 0; i < childCount; i++) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, translate, 0, 0);
            translateAnimation.setDuration(ANIMATION_DURATION_TIME);
            translateAnimation.setFillAfter(true);
            if (i == currenItem) {
                translateAnimation.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        mAnimationRunning = true;
                        rotateAnimator.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        for (int j = 0; j < getChildCount(); j++) {
                            getChildAt(j).clearAnimation();
                        }
                        mRequstLayout = true;
                        requestLayout();
                        mAnimationRunning = false;
                        mModeChangeListener.onModeChange(currenItem);
//                        if (mAnimationCount > 0) {
//                            ScrollLinearLayout.this.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mAnimationCount--;
//                                    mCurrenItem = mCurrentItemCopy;
//                                    int lastItem = mScrollRight ? mCurrentItemCopy + 1 : mCurrentItemCopy - 1;
//                                    startAnimation(mCurrentItemCopy, lastItem);
//                                    updateTextColor();
//                                }
//                            });
//                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
            mAnimationRunning = true;
            getChildAt(i).startAnimation(translateAnimation);
        }
    }

    public void startTranslate(int start, final int end) {

        if (mAnimationRunning) {
            return;
        }

        View currentView = getChildAt(end);
        final int width = currentView.getWidth();
        final int childCount = getChildCount();

        int translate = getWidth() / 2 - currentView.getLeft() - width / 2;
        Log.i(TAG, "translate = " + translate);
        for (int i = 0; i < childCount; i++) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, translate, 0, 0);
            translateAnimation.setDuration(ANIMATION_DURATION_TIME);
            translateAnimation.setFillAfter(true);
            if (i == start) {
                translateAnimation.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        mAnimationRunning = true;
                        mCurrenItem = end;
                        updateTextColor();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        for (int j = 0; j < getChildCount(); j++) {
                            getChildAt(j).clearAnimation();
                        }
                        mModeChangeListener.onModeChange(end);
                        mRequstLayout = true;
                        requestLayout();
                        mAnimationRunning = false;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
            mAnimationRunning = true;
            getChildAt(i).startAnimation(translateAnimation);
        }
    }

    public int getCurrentItem() {
        return mCurrenItem;
    }

    public void setDefaultCurrentItem(int currentItem) {
        mCurrenItem = currentItem;
    }

    public boolean IsAnimationRunning() {
        return mAnimationRunning;
    }

    public interface ModeChangeListener {
        void onModeChange(int mCurrentItem);
    }

    public void setModeChangeListener(ModeChangeListener mModeChangeListener) {
        this.mModeChangeListener = mModeChangeListener;
    }
}
