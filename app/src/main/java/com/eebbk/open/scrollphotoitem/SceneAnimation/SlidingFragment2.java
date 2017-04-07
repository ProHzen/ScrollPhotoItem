package com.eebbk.open.scrollphotoitem.SceneAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/5 15:52
 * Email:  369013520@qq.com
 */

public class SlidingFragment2 extends Fragment {


    private static final String EXTRA_SAMPLE = "sample2";

    public static SlidingFragment2 newInstance() {
        SlidingFragment2 fragment = new SlidingFragment2();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scene_word_layout, container, false);
        return view;
    }
}
