package com.example.avalo.mlexercise;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SimpleSpaceDecorator extends RecyclerView.ItemDecoration {

    private int margin;

    public SimpleSpaceDecorator(Context context, @DimenRes int dimenRes) {
        margin = context.getResources().getDimensionPixelSize(dimenRes);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, margin, 0, margin);
    }
}
