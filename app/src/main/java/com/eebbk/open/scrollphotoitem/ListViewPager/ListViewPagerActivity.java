package com.eebbk.open.scrollphotoitem.ListViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;
import com.tmall.ultraviewpager.UltraViewPager;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 8:24
 * Email:  369013520@qq.com
 */

public class ListViewPagerActivity extends AppCompatActivity {

    private static final String TAG = ListViewPagerActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private CollectionViewAdapter mCollectionViewAdapter;
    private List<CollectionBean> mCollectionBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_pager);

        initData();


        UltraViewPager ultraViewPager = (UltraViewPager) findViewById(R.id.ula_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        CollectionFragment fragment = new CollectionFragment();

        UltraViewPagerAdapter ultraViewPagerAdapter = new UltraViewPagerAdapter(getSupportFragmentManager(),
                fragment, mCollectionBeans);
        ultraViewPager.setAdapter(ultraViewPagerAdapter);
        ultraViewPager.setInfiniteLoop(true);

        ultraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, "onPageScrolled: position = " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: position = " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // state == 1 正在滑动
                // state == 2 滑动完毕
                // state == 0 什么都没发生
                Log.i(TAG, "onPageScrollStateChanged: state = " + state);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.collection_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mCollectionViewAdapter = new CollectionViewAdapter(this, R.layout.collection_list_adapter, mCollectionBeans);
        mCollectionViewAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Log.i(TAG, "onItemClick: position = " + position);
                ultraViewPager.setCurrentItem(position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        mRecyclerView.setAdapter(mCollectionViewAdapter);

    }

    private void initData() {
        mCollectionBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mCollectionBeans.add(new CollectionBean().setTitleContent("hasAnswerLcok\":false,\"index\":0,\"questionId\":\"xiaoyuanID\",\"questionType\":1,\"rank\":1,\"score\":\"0.2175066312997348\",\"searchTime\":173,\"totalSearchTime\":953,\"webUrl\":\"http://actcdn.eebbk.com/prod-yjs-pad/c_search-white-pad_175af09.html\",\"x\n" +
                    "Questions\":{\"answer\":\"\\u003chtml\\u003e\\n \\u003chead\\u003e\\u003c/head\\u003e\\n \\u003cbody\\u003e\\n  \\u003cdiv id\\u003d\\\"answer\\\"\\u003e \\n   \\u003cp\\u003e此题答案为："));
        }
    }
}
