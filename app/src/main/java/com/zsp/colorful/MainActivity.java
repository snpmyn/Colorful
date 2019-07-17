package com.zsp.colorful;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.zsp.colorful.library.BaseColorfulActivity;
import com.zsp.colorful.library.ColorPickerDialog;
import com.zsp.colorful.library.Colorful;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @decs: 主页
 * @author: 郑少鹏
 * @date: 2019/7/17 11:40
 */
public class MainActivity extends BaseColorfulActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 继承BaseColorfulActivity无需下配
        /*Colorful.applyTheme(this);*/
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

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
