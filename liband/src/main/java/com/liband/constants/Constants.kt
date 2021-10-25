package com.liband.constants


import android.os.Environment
import java.text.DecimalFormat

object Constants {
    const val APP_LANG = "app_lang"
    const val SPLASH_TIME_OUT = 3000
    const val CACHE_SIZE = 10 * 1024 * 1024
    const val MAX_STALE = 60 * 60 * 24 * 7

    val DOWNLOADPATH = (Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
            + "/"
            + " Downloads/")


    const val INTENT_TYPE_TEXT = "text/plain"
    const val INTENT_TYPE_IMAGE = "image/*"
    const val INTENT_TYPE_FILE = "*/*"



}
