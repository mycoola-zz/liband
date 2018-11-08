package com.liband.utils;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.liband.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class SnackbarUtils {

    private static Snackbar snackbar;

    public static void loadSnackBar(String message, AppCompatActivity activity, int color) {
        if (activity != null) {
            snackbar = Snackbar.make(
                    activity.findViewById(android.R.id.content), message,
                    Snackbar.LENGTH_LONG);

//              .setAction(
//                    activity.getResources().getString(R.string.ok),
//                    new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                        }
//                    })

//            snackbar.setActionTextColor(activity.getResources().getColor(
//                    R.color.white));
            View snackbarView = snackbar.getView();
            final TextView tv = snackbarView.findViewById(R.id.snackbar_text);
            tv.setTextColor(Color.WHITE);
            final int textSize = (int) activity.getResources().getDimension(R.dimen._5ssp);
            tv.setTextSize(textSize);
            snackbarView.setBackgroundColor(ContextCompat.getColor(activity, color));
            snackbar.show();
        }
    }


    public static void loadSnackBar(final View view, String message, AppCompatActivity activity, int color) {
        if (activity != null) {
            snackbar = Snackbar.make(
                    view, message,
                    Snackbar.LENGTH_LONG);

//              .setAction(
//                    activity.getResources().getString(R.string.ok),
//                    new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                        }
//                    })

//            snackbar.setActionTextColor(activity.getResources().getColor(
//                    R.color.white));
            View snackbarView = snackbar.getView();
            final TextView tv = snackbarView.findViewById(R.id.snackbar_text);
            tv.setTextColor(Color.WHITE);
            final int textSize = (int) activity.getResources().getDimension(R.dimen._5ssp);
            tv.setTextSize(textSize);
            snackbarView.setBackgroundColor(ContextCompat.getColor(activity, color));
            snackbar.show();
        }
    }


    public static void cancelSnackBar() {
        if (snackbar != null)
            snackbar.dismiss();
    }


}
