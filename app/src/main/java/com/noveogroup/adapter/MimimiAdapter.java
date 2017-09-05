package com.noveogroup.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.noveogroup.util.Util;

import java.util.List;

public class MimimiAdapter extends ArrayAdapter<Bitmap> {


    public MimimiAdapter(Context context, Bitmap[] bitmaps) {
        super(context, 0, bitmaps);
    }

    public MimimiAdapter(Context context, List<Bitmap> bitmaps) {
        super(context, 0, bitmaps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = new ImageView(getContext());
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        viewHolder.imageView.setImageBitmap(getItem(position));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Util.getAppropriateSizes(getContext()).getWidth(), Util.getAppropriateSizes(getContext()).getHeight());
        viewHolder.imageView.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.selected_item, null));
        viewHolder.imageView.setLayoutParams(layoutParams);

        return convertView;
    }


    static class ViewHolder {
        ImageView imageView;
    }


}
