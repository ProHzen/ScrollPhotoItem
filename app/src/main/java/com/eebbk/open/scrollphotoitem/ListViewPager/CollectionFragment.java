package com.eebbk.open.scrollphotoitem.ListViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 14:17
 * Email:  369013520@qq.com
 */

public class CollectionFragment extends Fragment {

    private FragmentManager mFragmentManager;
    private TextView mContentTv;
    private String mContent;

    public static CollectionFragment newInstance(String contentTv) {
        Bundle args = new Bundle();
        CollectionFragment fragment = new CollectionFragment();
        args.putString("content", contentTv);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString("content");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment, container, false);
        mFragmentManager =  getChildFragmentManager();
        mContentTv = (TextView) view.findViewById(R.id.tv_fragment);
        mContentTv.setText(mContent);
        return view;
    }

    public void setContent(String content) {
        if (mContentTv != null) {
            mContentTv.setText(content);
        }
    }
}
