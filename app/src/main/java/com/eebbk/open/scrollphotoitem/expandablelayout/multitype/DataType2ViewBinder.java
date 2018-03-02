package com.eebbk.open.scrollphotoitem.expandablelayout.multitype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;
import com.eebbk.open.scrollphotoitem.expandablelayout.bean.DisplayCharacterBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/25 9:23
 * Email:  369013520@qq.com
 */

public class DataType2ViewBinder extends ItemViewBinder<DisplayCharacterBean, DataType2ViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_data_type2, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DisplayCharacterBean data) {
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;


        ViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(android.R.id.title);
        }


        void setTitle(String title) {
            titleView.setText(title);
        }
    }
}
