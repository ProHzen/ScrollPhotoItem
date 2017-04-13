package com.eebbk.open.scrollphotoitem.Lottie;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/1 10:12
 * Email:  369013520@qq.com
 */

public class LottieActivity extends AppCompatActivity implements View.OnClickListener {


    private LottieAnimationView mLottieAnimationView;
    private Button mButton;
    private LottieComposition mLottieComposition;
    private boolean isStart = true;

    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_layout);

        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        mButton = (Button) findViewById(R.id.btn_start);
        mButton1 = (Button) findViewById(R.id.btn_start1);
        mButton2 = (Button) findViewById(R.id.btn_start2);
        mButton3 = (Button) findViewById(R.id.btn_start3);
        mButton4 = (Button) findViewById(R.id.btn_start4);
        mButton5 = (Button) findViewById(R.id.btn_start5);
        mButton6 = (Button) findViewById(R.id.btn_start6);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    mLottieAnimationView.setAnimation("camera_downd.json", LottieAnimationView.CacheStrategy.Weak);
                } else {
                    mLottieAnimationView.setAnimation("camera_end.json", LottieAnimationView.CacheStrategy.Weak);
                }
                isStart = !isStart;
                mLottieAnimationView.playAnimation();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_start1:
                mLottieAnimationView.setAnimation("tuku_end.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            case R.id.btn_start2:
                mLottieAnimationView.setAnimation("tuku_star.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            case R.id.btn_start3:
                mLottieAnimationView.setAnimation("button_end.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            case R.id.btn_start4:
                mLottieAnimationView.setAnimation("button_star.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            case R.id.btn_start5:
                mLottieAnimationView.setAnimation("camera_camera_dago.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            case R.id.btn_start6:
                mLottieAnimationView.setAnimation("camera_dago_camera.json", LottieAnimationView.CacheStrategy.Weak);
                mLottieAnimationView.playAnimation();
                break;
            default:
                break;
        }
    }
}
