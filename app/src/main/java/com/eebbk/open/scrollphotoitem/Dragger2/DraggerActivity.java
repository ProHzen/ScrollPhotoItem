package com.eebbk.open.scrollphotoitem.Dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

import javax.inject.Inject;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/22 8:55
 * Email:  369013520@qq.com
 */

public class DraggerActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Inject
    UserModel mUserModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        ContainerComponent containerComponent = DaggerContainerComponent.builder().
                activityComponent(mActivityComponent).containerModule(new ContainerModule()).build();
        containerComponent.inject(this);
        ((TextView)findViewById(R.id.tv_msg)).setText("age = " + mUserModel.getAge() + " name = " + mUserModel.getName());
    }
}
