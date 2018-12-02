package com.liband.utils

import android.graphics.drawable.GradientDrawable
import android.view.View

object DrawablesUtil {

    fun changeBackgroundDrawable(view: View, solidColor: Int, strokeColor: Int, strokeWidth: Int, radiusNumber: Float) {

        val drawable = view.background as GradientDrawable
        drawable.setColor(solidColor)
        drawable.setStroke(strokeWidth, strokeColor)
        drawable.cornerRadius = radiusNumber

    }

}
