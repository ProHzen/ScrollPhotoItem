package com.eebbk.open.scrollphotoitem.RippleView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 *
 * @author: YangShangZhen
 * @date: 2018/2/27 14:54
 */

public class RippleViewActivity extends AppCompatActivity {

    RippleView mRippleView;
    RippleViewButton mRippleViewButton;
    ChineseWordTv mChineseWordTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);

        mRippleView = (RippleView) findViewById(R.id.ripple);
        mRippleViewButton = (RippleViewButton) findViewById(R.id.ripple_button);
        mChineseWordTv = (ChineseWordTv) findViewById(R.id.chinese_word_tv);

        mRippleView.setRippleListener(new OnRippleListener() {
            @Override
            public void ripple() {
                mChineseWordTv.doSelectAnimation();
            }

            @Override
            public void disappear() {
                mChineseWordTv.doDisappearAnimation();
            }
        });
    }
}
