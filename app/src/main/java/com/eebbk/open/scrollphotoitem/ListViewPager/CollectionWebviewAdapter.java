package com.eebbk.open.scrollphotoitem.ListViewPager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 14:49
 * Email:  369013520@qq.com
 */

public class CollectionWebviewAdapter extends PagerAdapter {

    private List<View> mViewList;
    private List<CollectionBean> mCollectionBeans;

    public CollectionWebviewAdapter(List<View> viewList, List<CollectionBean> collectionBeans) {
        mViewList = viewList;
        mCollectionBeans = collectionBeans;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }
}
