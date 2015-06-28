package com.thorrism.materialdesignskeleton.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Simple ImageView shaped into a square for effectively displaying
 * images in a fixed sized square based on the width.
 * <p/>
 * Created by Lucas Crawford on 6/27/2015.
 */
public class SquareImageView extends ImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareImageView(Context context, AttributeSet attrs, int id) {
        super(context, attrs, id);
    }

    @Override
    public void onMeasure(int measuredWidth, int measuredHeight) {
        super.onMeasure(measuredWidth, measuredHeight);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
