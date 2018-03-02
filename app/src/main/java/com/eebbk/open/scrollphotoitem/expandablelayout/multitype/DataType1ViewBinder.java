package com.eebbk.open.scrollphotoitem.expandablelayout.multitype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;
import com.eebbk.open.scrollphotoitem.expandablelayout.ExpandableLayout;
import com.eebbk.open.scrollphotoitem.expandablelayout.bean.DisplayCharacterBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/25 8:59
 * Email:  369013520@qq.com
 */

public class DataType1ViewBinder extends ItemViewBinder<DisplayCharacterBean, DataType1ViewBinder.ViewHolder>{


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_data_type1, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DisplayCharacterBean data) {
        holder.setTitle("字义");
        holder.setTv1(data.getRadicals());
        holder.setTv2(data.getStrokes());
        holder.setTv3(data.getStructure());
        holder.setTv4(data.getStrokesOrderUrl());
        holder.setTv5(data.getCharacterSimilarity());
        holder.setTv6(data.getFallibilityHint());
        showExpandLayout(holder);
    }

    private void showExpandLayout(@NonNull ViewHolder holder) {
        if (holder.expandableLayout.isOpened()) {
            holder.expandableLayout.hide();
        } else {
            holder.expandableLayout.show();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ExpandableLayout expandableLayout;
        TextView headerTv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;
        ImageView iv1;

        ViewHolder(View itemView) {
            super(itemView);
            expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.first);
            FrameLayout contentLayout = expandableLayout.getContentLayout();
            headerTv = (TextView) expandableLayout.getHeaderLayout().findViewById(R.id.header_text);
            tv1 = (TextView) contentLayout.findViewById(R.id.tv1);
            tv2 = (TextView) contentLayout.findViewById(R.id.tv2);
            tv3 = (TextView) contentLayout.findViewById(R.id.tv3);
            tv4 = (TextView) contentLayout.findViewById(R.id.tv4);
            tv5 = (TextView) contentLayout.findViewById(R.id.tv5);
            tv6 = (TextView) contentLayout.findViewById(R.id.tv6);
            iv1 = (ImageView) contentLayout.findViewById(R.id.iv_show_bishun);
        }

        void setTitle(String title) {
            headerTv.setText(title);
        }

        void setTv1(String stv1) {
            tv1.setText(stv1);
        }

        void setTv2(String stv2) {
            tv2.setText(stv2);
        }

        void setTv3(String stv3) {
            tv3.setText(stv3);
        }

        void setTv4(String url) {
            tv4.setText(url);
        }

        void setTv5(String stv5) {
            tv5.setText(stv5);
        }

        void setTv6(String stv6) {
            tv6.setText(stv6);
        }
    }
}
