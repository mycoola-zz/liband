package com.liband.utils

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import com.liband.constants.Constants
import okhttp3.Cache


object NetUtil {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    fun isGPSEnable(context: Context): Boolean {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }


    fun getNetworkCache(context: Context): Cache = Cache(context.cacheDir, Constants.CACHE_SIZE.toLong())

}
