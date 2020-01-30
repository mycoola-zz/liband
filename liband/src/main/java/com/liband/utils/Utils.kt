package com.liband.utils

import android.app.Application
import android.os.Build
import android.util.TypedValue
import android.view.View
import java.util.*
import kotlin.math.roundToInt


object Utils {

    val deviceName: String
        get() {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                model.toUpperCase(Locale.ROOT)
            } else {
                manufacturer.toUpperCase(Locale.ROOT) + " " + model
            }
        }

    /**
     * Converting dp to pixel
     */
    fun dpToPx(application: Application, dp: Int): Int {
        val r = application.resources
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics).roundToInt()
    }

    fun reflectVisibilityOfView(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }

}
