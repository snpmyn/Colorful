package com.zsp.colorful.library;

import android.content.Context;

import androidx.annotation.StyleRes;

import timber.log.Timber;

/**
 * @decs: ThemeDelegate
 * @author: 郑少鹏
 * @date: 2019/7/17 15:07
 */
public class ThemeDelegate {
    private final Colorful.ThemeColor primaryColor;
    private final Colorful.ThemeColor accentColor;
    private final boolean translucent;
    private final boolean dark;
    @StyleRes
    private final int styleResPrimary;
    @StyleRes
    private final int styleResAccent;
    @StyleRes
    private final int styleResBase;

    ThemeDelegate(Context context, Colorful.ThemeColor primary, Colorful.ThemeColor accent, boolean translucent, boolean dark) {
        this.primaryColor = primary;
        this.accentColor = accent;
        this.translucent = translucent;
        this.dark = dark;
        long curTime = System.currentTimeMillis();
        styleResPrimary = context.getResources().getIdentifier("primary" + primary.ordinal(), "style", context.getPackageName());
        styleResAccent = context.getResources().getIdentifier("accent" + accent.ordinal(), "style", context.getPackageName());
        styleResBase = dark ? R.style.Colorful_Dark : R.style.Colorful_Light;
        Timber.d("ThemeDelegate fetched theme in %s milliseconds", (System.currentTimeMillis() - curTime));
    }

    @StyleRes
    int getStyleResPrimary() {
        return styleResPrimary;
    }

    @StyleRes
    int getStyleResAccent() {
        return styleResAccent;
    }

    @StyleRes
    int getStyleResBase() {
        return styleResBase;
    }

    Colorful.ThemeColor getPrimaryColor() {
        return primaryColor;
    }

    Colorful.ThemeColor getAccentColor() {
        return accentColor;
    }

    boolean isTranslucent() {
        return translucent;
    }

    public boolean isDark() {
        return dark;
    }
}
