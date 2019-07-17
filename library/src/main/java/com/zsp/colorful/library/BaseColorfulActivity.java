package com.zsp.colorful.library;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * @decs: BaseColorful页
 * @author: 郑少鹏
 * @date: 2019/7/17 12:18
 */
public abstract class BaseColorfulActivity extends AppCompatActivity {
    private static final String TAG = "BaseColorfulActivity";
    private String themeString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeString = Colorful.getThemeString();
        setTheme(Colorful.getThemeDelegate().getStyleResBase());
        getTheme().applyStyle(Colorful.getThemeDelegate().getStyleResPrimary(), true);
        getTheme().applyStyle(Colorful.getThemeDelegate().getStyleResAccent(), true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Colorful.getThemeDelegate().isTranslucent()) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null,
                    ContextCompat.getColor(this, Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
            setTaskDescription(taskDescription);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!Colorful.getThemeString().equals(themeString)) {
            Log.d(TAG, "Theme change detected, restarting activity.");
            recreate();
        }
    }
}
