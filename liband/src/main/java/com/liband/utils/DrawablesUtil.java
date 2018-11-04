package com.liband.utils;

import android.graphics.drawable.GradientDrawable;
import android.view.View;

public class DrawablesUtil {

    public static void changeBackgroundDrawable(View view, int solidColor, int strokeColor, int strokeWidth, float radiusNumber) {

        GradientDrawable drawable = (GradientDrawable) view.getBackground();
        drawable.setColor(solidColor);
        drawable.setStroke(strokeWidth, strokeColor);
        drawable.setCornerRadius(radiusNumber);

    }

}
