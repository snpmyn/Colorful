package application;

import android.app.Application;

import com.zsp.colorful.BuildConfig;
import com.zsp.colorful.library.Colorful;
import com.zsp.utilone.timber.configure.TimberInitConfigure;

/**
 * Created on 2019/7/17.
 *
 * @author 郑少鹏
 * @desc 应用
 */
public class ColorfulApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化配置
        initConfiguration();
    }

    /**
     * 初始化配置
     */
    private void initConfiguration() {
        // timber
        TimberInitConfigure.initTimber(BuildConfig.DEBUG);
        // colorful
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(false)
                .dark(true);
        Colorful.init(this);
    }
}
