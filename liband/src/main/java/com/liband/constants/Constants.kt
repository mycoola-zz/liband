package com.liband.constants


import android.os.Environment

object Constants {
    const val APP_LANG = "app_lang"
    const val SPLASH_TIME_OUT = 3000

    val DOWNLOADPATH = (Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
            + "/"
            + " Downloads/")


    const val INTENT_TYPE_TEXT = "text/plain"
    const val INTENT_TYPE_IMAGE = "image/*"
    const val INTENT_TYPE_FILE = "*/*"
}
