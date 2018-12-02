package com.liband.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.liband.R


object SnackbarUtils {

    private var snackbar: Snackbar? = null

    fun loadSnackBar(message: String, activity: Activity?, color: Int) {
        if (activity != null) {
            snackbar = Snackbar.make(
                    activity.findViewById(android.R.id.content), message,
                    Snackbar.LENGTH_LONG)

            //              .setAction(
            //                    activity.getResources().getString(R.string.ok),
            //                    new OnClickListener() {
            //                        @Override
            //                        public void onClick(View v) {
            //                        }
            //                    })

            //            snackbar.setActionTextColor(activity.getResources().getColor(
            //                    R.color.white));
            val snackbarView = snackbar!!.view
            val tv = snackbarView.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(Color.WHITE)
            val textSize = activity.resources.getDimension(R.dimen._5ssp).toInt()
            tv.textSize = textSize.toFloat()
            snackbarView.setBackgroundColor(ContextCompat.getColor(activity, color))
            snackbar!!.show()
        }
    }


    fun loadSnackBar(view: View, message: String, activity: Activity?, color: Int) {
        if (activity != null) {
            snackbar = Snackbar.make(
                    view, message,
                    Snackbar.LENGTH_LONG)

            //              .setAction(
            //                    activity.getResources().getString(R.string.ok),
            //                    new OnClickListener() {
            //                        @Override
            //                        public void onClick(View v) {
            //                        }
            //                    })

            //            snackbar.setActionTextColor(activity.getResources().getColor(
            //                    R.color.white));
            val snackbarView = snackbar!!.view
            val tv = snackbarView.findViewById<TextView>(R.id.snackbar_text)
            tv.setTextColor(Color.WHITE)
            val textSize = activity.resources.getDimension(R.dimen._5ssp).toInt()
            tv.textSize = textSize.toFloat()
            snackbarView.setBackgroundColor(ContextCompat.getColor(activity, color))
            snackbar!!.show()
        }
    }


    fun cancelSnackBar() {
        if (snackbar != null)
            snackbar!!.dismiss()
    }


}
