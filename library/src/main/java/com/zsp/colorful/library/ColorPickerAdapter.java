package com.zsp.colorful.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @decs: 色选适配器
 * @author: 郑少鹏
 * @date: 2019/7/17 15:26
 */
class ColorPickerAdapter extends RecyclerView.Adapter<ColorPickerAdapter.ItemViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;

    ColorPickerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return Colorful.ThemeColor.values().length;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.circle.setColor(ContextCompat.getColor(context, Colorful.ThemeColor.values()[i].getColorRes()));
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final ItemViewHolder holder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.color_picker_item, viewGroup, false));
        holder.circle.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(Colorful.ThemeColor.values()[holder.getAdapterPosition()]);
            }
        });
        return holder;
    }

    void setOnItemClickListener(OnItemClickListener l) {
        onItemClickListener = l;
    }

    interface OnItemClickListener {
        /**
         * 条目点击
         *
         * @param color 色
         */
        void onItemClick(Colorful.ThemeColor color);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CircularView circle;

        ItemViewHolder(View v) {
            super(v);
            circle = ((CircularView) v);
        }
    }
}
