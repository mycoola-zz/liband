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
        if (value is Boolean) {
            editor.putBoolean(key, (value as Boolean?)!!)
        } else if (value is Int) {
            editor.putInt(key, (value as Int?)!!)
        } else if (value is Float) {
            editor.putFloat(key, (value as Float?)!!)
        } else if (value is Long) {
            editor.putLong(key, (value as Long?)!!)
        } else if (value is String) {
            editor.putString(key, value as String?)
        } else if (value is Enum<*>) {
            editor.putString(key, value.toString())
        } else if (value != null) {
            throw RuntimeException("Attempting to save non-supported preference")
        }

        editor.commit()
    }

    operator fun <T> get(key: String): T {
        return sharedPreferences.all[key] as T
    }

    operator fun <T> get(key: String, defValue: T): T {
        val returnValue = sharedPreferences.all[key] as T
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
