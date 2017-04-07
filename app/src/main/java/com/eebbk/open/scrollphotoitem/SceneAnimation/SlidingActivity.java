package com.eebbk.open.scrollphotoitem.SceneAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/5 15:57
 * Email:  369013520@qq.com
 */

public class SlidingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        setSlidingOneFragment();
    }

    private void setSlidingOneFragment() {
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        SlidingFragment1 slidingFragment1 = SlidingFragment1.newInstance();
//        slidingFragment1.setReenterTransition(slideTransition);
//        slidingFragment1.setExitTransition(slideTransition);
        slidingFragment1.setSharedElementEnterTransition(new ChangeBounds());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_layout, slidingFragment1)
                .commit();
    }
}
