package com.terry.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create by xiongfeng on 2020/7/15 0015
 */
public class TagSpan extends ReplacementSpan {
    @Override
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i1, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return 0;
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i1, float v, int i2, int i3, int i4, @NonNull Paint paint) {

    }
}
