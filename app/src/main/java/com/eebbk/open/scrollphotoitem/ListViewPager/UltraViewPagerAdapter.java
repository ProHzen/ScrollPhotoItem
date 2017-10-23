package com.eebbk.open.scrollphotoitem.ListViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 14:05
 * Email:  369013520@qq.com
 */

public class UltraViewPagerAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = UltraViewPagerAdapter.class.getSimpleName();

    private Fragment mFragment;
    private List<CollectionBean> mCollectionBeans;

    UltraViewPagerAdapter(FragmentManager fm, Fragment fragment, List<CollectionBean> beans) {
        super(fm);
        mFragment = fragment;
        mCollectionBeans = new ArrayList<>();
        mCollectionBeans = beans;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i(TAG, "getItem: position = " + position);
        return CollectionFragment.newInstance(mCollectionBeans.get(position).getTitleContent() + position);
    }

    @Override
    public int getCount() {
        return mCollectionBeans.size();
    }

}
