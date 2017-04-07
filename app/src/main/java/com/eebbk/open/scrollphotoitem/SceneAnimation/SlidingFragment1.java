package com.eebbk.open.scrollphotoitem.SceneAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/5 15:52
 * Email:  369013520@qq.com
 */

public class SlidingFragment1 extends Fragment {

    private static final String EXTRA_SAMPLE = "sample1";
    private ImageView mLayout;

    public static SlidingFragment1 newInstance() {
        SlidingFragment1 fragment = new SlidingFragment1();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scene_scan_layout, container, false);
        mLayout = (ImageView) view.findViewById(R.id.relativeLayout);
        view.findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingFragment2 sharedElementFragment2 = SlidingFragment2.newInstance();

                Slide slideTransition = new Slide(Gravity.RIGHT);
                slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

                ChangeBounds changeBoundsTransition = new ChangeBounds();
                changeBoundsTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));

//                sharedElementFragment2.setEnterTransition(slideTransition);
                sharedElementFragment2.setAllowEnterTransitionOverlap(false);
                sharedElementFragment2.setAllowReturnTransitionOverlap(false);
                sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

                getFragmentManager().beginTransaction()
                        .replace(R.id.fl_layout, sharedElementFragment2)
                        .addToBackStack(null)
                        .addSharedElement(mLayout, getString(R.string.blue_name))
                        .commit();
            }
        });
        return view;
    }
}
