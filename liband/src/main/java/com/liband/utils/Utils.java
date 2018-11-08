package com.liband.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;


public class Utils {

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(Application application, int dp) {
        Resources r = application.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static void reflectVisibilityOfView(View view) {
        view.setVisibility(view.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model.toUpperCase();
        } else {
            return manufacturer.toUpperCase() + " " + model;
        }
    }

    public static void hideSoftKeyboard(Context mActivity) {
        if (mActivity != null && !((Activity) mActivity).isFinishing()) {
            final InputMethodManager inputMethodManager = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (Objects.requireNonNull(inputMethodManager).isActive()) {
                if (((Activity) mActivity).getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(((Activity) mActivity).getCurrentFocus()).getWindowToken(), 0);
                }
            }
        }
    }

}
