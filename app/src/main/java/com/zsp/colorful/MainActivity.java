package com.zsp.colorful;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.zsp.colorful.library.BaseColorfulActivity;
import com.zsp.colorful.library.ColorPickerDialog;
import com.zsp.colorful.library.Colorful;
import com.zsp.utilone.permission.SoulPermissionUtils;
import com.zsp.utilone.toast.ToastUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @decs: 主页
 * @author: 郑少鹏
 * @date: 2019/7/17 11:40
 */
public class MainActivity extends BaseColorfulActivity {
    private SoulPermissionUtils soulPermissionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 继承BaseColorfulActivity无需下配
        /*Colorful.applyTheme(this);*/
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initConfiguration();
        execute();
    }

    private void initConfiguration() {
        soulPermissionUtils = new SoulPermissionUtils();
    }

    private void execute() {
        soulPermissionUtils.checkAndRequestPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, soulPermissionUtils,
                true, new SoulPermissionUtils.CheckAndRequestPermissionCallBack() {
                    @Override
                    public void onPermissionOk() {

                    }

                    @Override
                    public void onPermissionDeniedNotRationaleInMiUi(String s) {
                        ToastUtils.shortShow(MainActivity.this, s);
                    }

                    @Override
                    public void onPermissionDeniedNotRationaleWithoutLoopHint(String s) {

                    }
                });
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick({R.id.mainActivityMbDialog, R.id.mainActivityMbChange})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 对话框
            case R.id.mainActivityMbDialog:
                new MaterialAlertDialogBuilder(this)
                        .setMessage(R.string.dialog)
                        .setPositiveButton(R.string.close, (dialogInterface, i) -> {
                            Colorful.config(MainActivity.this)
                                    .primaryColor(Colorful.ThemeColor.BLUE)
                                    .accentColor(Colorful.ThemeColor.BLUE)
                                    .translucent(false)
                                    .dark(true)
                                    .apply();
                            dialogInterface.dismiss();
                        }).show();
                break;
            // 关闭
            case R.id.mainActivityMbChange:
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this);
                colorPickerDialog.setOnColorSelectedListener(color -> Colorful.config(MainActivity.this)
                        .primaryColor(color)
                        .accentColor(color)
                        .translucent(false)
                        .dark(true)
                        .apply());
                colorPickerDialog.show();
                break;
            default:
                break;
        }
    }
}
