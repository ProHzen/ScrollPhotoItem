package com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eebbk.open.scrollphotoitem.R;

public class MainActivity extends AppCompatActivity implements OnTouchListener, OnClickListener{

    ScrollLinearLayout mScrollLinearLayout;
    RelativeLayout mRootView;
    GestureDetector mGestureDetector;

    private static final int degreeLimit = 50;
    private static final int distanceLimit = 15;
    private boolean isScroll = false;

    private RecyclerView mRecyclerView;
    private ModeAdapter mAdapter;
    private List<String> mDatas;
    private LinearLayoutManager mLinearLayoutManager;
    private int mScreenWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootView = (RelativeLayout)findViewById(R.id.activity_main);
        mScrollLinearLayout = (ScrollLinearLayout)findViewById(R.id.scroll_layout);
        mScreenWidth = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();

        TextView mTvRotate = (TextView) findViewById(R.id.tv_rotate);
        mTvRotate.setPivotX(mTvRotate.getX() + mTvRotate.getWidth() / 3);
        mTvRotate.setScaleX(0.5f);

        mRootView.setOnTouchListener(this);
        mScrollLinearLayout.getParent();
        ModeChangeManager modeChangeManager = new ModeChangeManager(this);
        modeChangeManager.setScrollLinearLayout(mScrollLinearLayout);
        mGestureDetector = new GestureDetector(this, new OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                isScroll = false;
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                if (isScroll) return false;
                double degree = Math.atan(Math.abs(e2.getY() - e1.getY()) / Math.abs(e2.getX() - e1.getX())) * 180 /Math.PI;
                float delta = e2.getX() - e1.getX();
                if (delta > distanceLimit && degree < degreeLimit) {
                    isScroll = true;
                    mScrollLinearLayout.scrollToRight();
                } else if (delta < -distanceLimit && degree < degreeLimit) {
                    isScroll = true;
                    mScrollLinearLayout.scrollToLeft();
                }
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });


        mScrollLinearLayout.setModeChangeListener(new ScrollLinearLayout.ModeChangeListener() {
            @Override
            public void onModeChange(int index) {
                Log.i("ysz", " onModeChange = " + index);
            }
        });


        ((Button)findViewById(R.id.btn_jump)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollLinearLayout.startTranslate(2, 4);
            }
        });

        initDatas();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new ModeAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.scrollToPosition(4);
        mRecyclerView.setOnScrollListener(mOnScrollListener);
        mRecyclerView.smoothScrollBy(100, 0);
        initView();

    }

    private final int MSG_SCROLL = 1;

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            Log.i("ysz", " onScrollStateChanged ");
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                Message msg = new Message();
//                msg.what = MSG_SCROLL;
//                msg.arg1 = offset;
//                mHandler.sendMessage(msg);
            }
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SCROLL:
                    mRecyclerView.smoothScrollBy(msg.arg1, 0);
                    break;
            }
        }
    };

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>(Arrays.asList("延时摄影",
                "慢动作", "视频", "照片", "正方形", "全景"));
    }

    private TextView mTvLapseTime;
    private TextView mTvSlowMotion;
    private TextView mTvVideo;
    private TextView mTvPhoto;
    private TextView mTvSquare;
    private TextView mTvPanorama;

    private void initView() {
        mTvLapseTime = (TextView) findViewById(R.id.tv_lapse_time);
        mTvSlowMotion = (TextView) findViewById(R.id.tv_slow_motion);
        mTvVideo = (TextView) findViewById(R.id.tv_video);
        mTvPhoto = (TextView) findViewById(R.id.tv_photo);
        mTvSquare = (TextView) findViewById(R.id.tv_square);
        mTvPanorama = (TextView) findViewById(R.id.tv_panorma);

        mTvLapseTime.setOnClickListener(this);
        mTvSlowMotion.setOnClickListener(this);
        mTvVideo.setOnClickListener(this);
        mTvPhoto.setOnClickListener(this);
        mTvSquare.setOnClickListener(this);
        mTvPanorama.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_lapse_time:
                Log.i("ysz", " tv_lapse_time ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.LAPSE_TIME_INDEX);
                break;
            case R.id.tv_slow_motion:
                Log.i("ysz", " tv_slow_motion ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.SLOW_MOTION_INDEX);
                break;
            case R.id.tv_video:
                Log.i("ysz", " tv_video ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.VIDEO_INDEX);
                break;
            case R.id.tv_photo:
                Log.i("ysz", " tv_photo ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.PHOTO_INDEX);
                break;
            case R.id.tv_square:
                Log.i("ysz", " tv_square ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.SQUARE_INDEX);
                break;
            case R.id.tv_panorma:
                Log.i("ysz", " tv_panorma ");
                mScrollLinearLayout.startTranslate(mScrollLinearLayout.getCurrentItem(), ModeChangeManager.PANORAMA_INDEX);
                break;
            default:
                break;
        }
    }
}
