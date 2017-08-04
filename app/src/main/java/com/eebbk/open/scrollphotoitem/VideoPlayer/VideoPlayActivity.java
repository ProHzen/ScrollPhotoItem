package com.eebbk.open.scrollphotoitem.VideoPlayer;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eebbk.open.scrollphotoitem.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.CURRENT_STATE_NORMAL;
import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.CURRENT_STATE_PAUSE;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/8/3 10:15
 * Email:  369013520@qq.com
 */

public class VideoPlayActivity extends AppCompatActivity {
//
    private JCVideoPlayerStandard mJCVideoPlayerStandard;
    private JCVideoPlayer mJCVideoPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        mJCVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        mJCVideoPlayerStandard.setUp("http://video-n002cdn.lewen.com/e70c5ac04cc140b48855a18eec3ace6b.avi",
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "一键搜");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("VideoPlayActivity", "currentState = " + mJCVideoPlayerStandard.currentState);
        if (mJCVideoPlayerStandard.currentState == CURRENT_STATE_NORMAL) {
            mJCVideoPlayerStandard.startButton.performClick();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mJCVideoPlayerStandard.release();
    }
}
