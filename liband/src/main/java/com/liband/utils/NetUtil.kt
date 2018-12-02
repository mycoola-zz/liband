package com.liband.utils

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import java.util.*


object NetUtil {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = Objects.requireNonNull(connectivityManager)
                .activeNetworkInfo
        return activeNetworkInfo != null
    }

    fun isGPSEnable(context: Context): Boolean {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return Objects.requireNonNull(manager).isProviderEnabled(LocationManager.GPS_PROVIDER)
    }


}
