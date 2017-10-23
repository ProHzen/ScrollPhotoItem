package com.eebbk.open.scrollphotoitem.ListViewPager;

import android.content.Context;

import com.eebbk.open.scrollphotoitem.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 10:00
 * Email:  369013520@qq.com
 */

public class CollectionViewAdapter extends CommonAdapter<CollectionBean>{

    private Context mContext;
    private List<CollectionBean> mCollectionBeans;

    CollectionViewAdapter(Context context, int layoutId, List<CollectionBean> datas) {
        super(context, layoutId, datas);
        mCollectionBeans = new ArrayList<>();
        mCollectionBeans = datas;
    }

    @Override
    protected void convert(ViewHolder holder, CollectionBean bean, int position) {
        holder.setText(R.id.tv_content, bean.getTitleContent());
    }
}
