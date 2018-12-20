package com.liband.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SharedPrefceUtils private constructor(application: Application) {

    private val sharedPreferences: SharedPreferences

    private val editor: SharedPreferences.Editor
        get() = sharedPreferences.edit()

    init {
        instance = this
        sharedPreferences = application.getSharedPreferences(application.packageName, Context.MODE_PRIVATE)
    }

    fun delete(key: String) {
        if (sharedPreferences.contains(key)) {
            editor.remove(key).commit()
        }
    }

    fun save(key: String, value: Any?) {
        val editor = editor
        when {
            value is Boolean -> editor.putBoolean(key, (value as Boolean?)!!)
            value is Int -> editor.putInt(key, (value as Int?)!!)
            value is Float -> editor.putFloat(key, (value as Float?)!!)
            value is Long -> editor.putLong(key, (value as Long?)!!)
            value is String -> editor.putString(key, value as String?)
            value is Enum<*> -> editor.putString(key, value.toString())
            value != null -> throw RuntimeException("Attempting to save non-supported preference")
        }

        editor.commit()
    }

    operator fun <T> get(key: String): Any? {
        return sharedPreferences.all[key]
    }

    operator fun <T> get(key: String, defValue: T): Any? {
        val returnValue = sharedPreferences.all[key]
        return returnValue ?: defValue
    }

    fun has(key: String): Boolean {
        return sharedPreferences.contains(key)
    }


    fun clearAllData() {
        val editor = editor
        editor.clear().commit()
    }

    companion object {
        private var instance: SharedPrefceUtils? = null

        @Synchronized
        fun getInstance(application: Application): SharedPrefceUtils {
            if (instance == null) {
                instance = SharedPrefceUtils(application)
            }
            return instance as SharedPrefceUtils
        }
    }


}
