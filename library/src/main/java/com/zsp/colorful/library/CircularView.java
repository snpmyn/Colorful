package com.zsp.colorful.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;

/**
 * @decs: CircularView
 * @author: 郑少鹏
 * @date: 2019/7/17 14:58
 */
public class CircularView extends View {
    Paint paint = new Paint();

    public CircularView(Context context) {
        super(context);
    }

    public CircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setColor(@ColorInt int color) {
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 原canvas.getWidth()、canvas.getHeight()
        canvas.drawCircle(Integer.valueOf(getWidth() / 2).floatValue(), Integer.valueOf(getHeight() / 2).floatValue(), Integer.valueOf(getWidth() / 2).floatValue(), paint);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
    }
}
