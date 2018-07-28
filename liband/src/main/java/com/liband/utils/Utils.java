package com.liband.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

import com.liband.App;

public class Utils {

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(int dp) {
        Resources r = App.getApp().getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static void reflectVisibilityOfView(View view) {
        view.setVisibility(view.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }
}
