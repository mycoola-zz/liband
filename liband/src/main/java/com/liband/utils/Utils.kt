package com.liband.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*


object Utils {

    val deviceName: String
        get() {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                model.toUpperCase()
            } else {
                manufacturer.toUpperCase() + " " + model
            }
        }

    /**
     * Converting dp to pixel
     */
    fun dpToPx(application: Application, dp: Int): Int {
        val r = application.resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }

    fun reflectVisibilityOfView(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }

    fun hideSoftKeyboard(mActivity: Context?) {
        if (mActivity != null && !(mActivity as Activity).isFinishing) {
            val inputMethodManager = mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            if (Objects.requireNonNull(inputMethodManager).isActive) {
                if (mActivity.currentFocus != null) {
                    inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(mActivity.currentFocus).windowToken, 0)
                }
            }
        }
    }

}
