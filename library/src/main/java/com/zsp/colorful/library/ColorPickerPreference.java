package com.zsp.colorful.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/**
 * @decs: ColorPickerPreference
 * @author: 郑少鹏
 * @date: 2019/7/17 15:07
 */
public class ColorPickerPreference extends Preference implements ColorPickerDialog.OnColorSelectedListener {
    private boolean primary;
    private boolean accent;

    public ColorPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.color_picker_preference);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ColorPicker);
        try {
            primary = ta.getBoolean(R.styleable.ColorPicker_primary_color, false);
            accent = ta.getBoolean(R.styleable.ColorPicker_accent_color, false);
        } finally {
            ta.recycle();
        }
    }

    @Override
    public void onColorSelected(Colorful.ThemeColor color) {
        if (primary) {
            Colorful.config(getContext())
                    .primaryColor(color)
                    .apply();
        } else if (accent) {
            Colorful.config(getContext())
                    .accentColor(color)
                    .apply();
        }
        if (getOnPreferenceChangeListener() != null) {
            getOnPreferenceChangeListener().onPreferenceChange(this, color);
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (primary) {
            ((CircularView) holder.findViewById(R.id.colorPickerPreferenceCv)).setColor(ContextCompat.getColor(getContext(), Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
        } else if (accent) {
            ((CircularView) holder.findViewById(R.id.colorPickerPreferenceCv)).setColor(ContextCompat.getColor(getContext(), Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
        }
    }

    @Override
    protected void onClick() {
        super.onClick();
        ColorPickerDialog dialog = new ColorPickerDialog(getContext());
        dialog.setOnColorSelectedListener(this);
        dialog.show();
    }
}
