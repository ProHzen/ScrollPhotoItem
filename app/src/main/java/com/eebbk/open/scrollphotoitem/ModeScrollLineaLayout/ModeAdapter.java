package com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/9 8:23
 * Email:  369013520@qq.com
 */

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

public class ModeAdapter extends RecyclerView.Adapter<ModeAdapter.ViewHolder>{

    private LayoutInflater mInflater;
    private List<String> mDatas;


    public ModeAdapter(Context mContext, List<String> datas) {
        mInflater = LayoutInflater.from(mContext);
        mDatas = datas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        TextView mTxt;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.adapter,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mTxt = (TextView) view
                .findViewById(R.id.tv_adapter);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.mTxt.setText(mDatas.get(i));
        viewHolder.mTxt.setRotationX(Math.abs(i-2)*15.0f);
    }


}
