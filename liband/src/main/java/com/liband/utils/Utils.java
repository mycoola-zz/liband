package com.liband.utils;

import android.content.res.Resources;
import android.util.TypedValue;

import com.liband.App;

public class Utils {

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(int dp) {
        Resources r = App.getApp().getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
