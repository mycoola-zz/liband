package com.liband.constants;


import android.os.Environment;

public class Constants {
    public static final String APP_LANG = "app_lang";
    public static final int SPLASH_TIME_OUT = 3000;

    public static String DOWNLOADPATH = Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            + "/"
            + " Downloads/";


    public static String INTENT_TYPE_TEXT = "text/plain";
    public static String INTENT_TYPE_IMAGE = "image/*";
    public static String INTENT_TYPE_FILE = "*/*";
}
