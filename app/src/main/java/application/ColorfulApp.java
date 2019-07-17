package application;

import android.app.Application;

import com.zsp.colorful.library.Colorful;

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
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(false)
                .dark(true);
        Colorful.init(this);
    }
}
