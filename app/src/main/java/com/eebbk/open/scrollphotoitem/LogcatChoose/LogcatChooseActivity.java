package com.eebbk.open.scrollphotoitem.LogcatChoose;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.eebbk.open.scrollphotoitem.ModeScrollLineaLayout.MainActivity;
import com.eebbk.open.scrollphotoitem.R;
import com.github.angads25.filepicker.controller.DialogSelectionListener;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/24 10:09
 * Email:  369013520@qq.com
 */

public class LogcatChooseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mChooseBtn;
    private DialogProperties properties;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        mChooseBtn = (Button) findViewById(R.id.btn_choose);
        mChooseBtn.setOnClickListener(this);
        setDialogProperties();
    }

    private void setDialogProperties() {
        properties = new DialogProperties();
        properties.selection_mode = DialogConfigs.MULTI_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(Environment.getExternalStorageDirectory() + "/.crash/");
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions = null;
    }

    @Override
    public void onClick(View v) {
        FilePickerDialog dialog = new FilePickerDialog(LogcatChooseActivity.this, properties);
        dialog.setTitle("Select a File");
        dialog.setDialogSelectionListener(new DialogSelectionListener() {

            @Override
            public void onSelectedFilePaths(String[] files) {
                ArrayList<Uri> uris = new ArrayList<Uri>();
                for (String file : files) {
                    uris.add(Uri.fromFile(new File(file)));
                }
                Intent share = new Intent(Intent.ACTION_SEND_MULTIPLE);
                ComponentName component = new ComponentName("com.tencent.mobileqq","com.tencent.mobileqq.activity.JumpActivity");
                share.setComponent(component);
                share.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                share.setType("*/*");
                startActivity(Intent.createChooser(share, "发送"));
            }
        });
        dialog.show();
    }
}
