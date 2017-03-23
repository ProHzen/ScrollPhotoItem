package com.eebbk.open.scrollphotoitem.SceneAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/3/23 17:06
 * Email:  369013520@qq.com
 */

public class SceneAnimationActivity extends AppCompatActivity{

    private boolean isSecond = true;
    private Button mGo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        mGo = (Button) findViewById(R.id.btn_click);
        final ViewGroup container = (ViewGroup)findViewById(R.id.rl_container);
        List<Integer> sceneLayouts = Arrays.asList(R.layout.scene_scan_layout,
                R.layout.scene_word_layout);

        final List<Scene> sceneList = new ArrayList<>();
        for (int layout : sceneLayouts) {
            Scene scene = Scene.getSceneForLayout(container, layout, this);
            sceneList.add(scene);
        }
        TransitionManager.go(sceneList.get(0));

        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSecond) {
                    TransitionManager.go(sceneList.get(1));
                } else {
                    TransitionManager.go(sceneList.get(0));
                }
                isSecond = !isSecond;
            }
        });
    }
}
