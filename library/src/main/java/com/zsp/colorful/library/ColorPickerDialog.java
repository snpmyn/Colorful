package com.zsp.colorful.library;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

/**
 * @decs: 色选对话框
 * @author: 郑少鹏
 * @date: 2019/7/17 12:20
 */
public class ColorPickerDialog extends AppCompatDialog implements View.OnClickListener, ColorPickerAdapter.OnItemClickListener {
    private OnColorSelectedListener onColorSelectedListener;

    public ColorPickerDialog(Context context) {
        super(context);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }

    @Override
    public void onItemClick(Colorful.ThemeColor color) {
        dismiss();
        if (onColorSelectedListener != null) {
            onColorSelectedListener.onColorSelected(color);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_picker_dialog);
        RecyclerView recyclerView = findViewById(R.id.colorPickerDialogRv);
        MaterialToolbar materialToolbar = findViewById(R.id.colorPickerDialogMt);
        if (materialToolbar != null) {
            materialToolbar.setNavigationOnClickListener(this);
            materialToolbar.setBackgroundColor(ContextCompat.getColor(getContext(), Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
            materialToolbar.setTitle(R.string.selectColor);
            materialToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            ColorPickerAdapter adapter = new ColorPickerAdapter(getContext());
            adapter.setOnItemClickListener(this);
            recyclerView.setAdapter(adapter);
        }
    }

    public void setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
        this.onColorSelectedListener = onColorSelectedListener;
    }

    public interface OnColorSelectedListener {
        /**
         * 色选
         *
         * @param color 色
         */
        void onColorSelected(Colorful.ThemeColor color);
    }
}
