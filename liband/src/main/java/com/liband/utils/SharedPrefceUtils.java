package com.liband.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefceUtils {
    private static SharedPrefceUtils instance;

    private SharedPreferences sharedPreferences;

    public static synchronized SharedPrefceUtils getInstance(Application application) {
        if (instance == null) {
            instance = new SharedPrefceUtils(application);
        }
        return instance;
    }

    private SharedPrefceUtils(Application application) {
        instance = this;
        sharedPreferences = application.getSharedPreferences(application.getPackageName(), Context.MODE_PRIVATE);
    }

    public void delete(String key) {
        if (sharedPreferences.contains(key)) {
            getEditor().remove(key).commit();
        }
    }

    public void save(String key, Object value) {
        final SharedPreferences.Editor editor = getEditor();
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            editor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-supported preference");
        }

        editor.commit();
    }

    public <T> T get(String key) {
        return (T) sharedPreferences.getAll().get(key);
    }

    public <T> T get(String key, T defValue) {
        final T returnValue = (T) sharedPreferences.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }

    public boolean has(String key) {
        return sharedPreferences.contains(key);
    }


    public void clearAllData() {
        final SharedPreferences.Editor editor = getEditor();
        editor.clear().commit();
    }

    private SharedPreferences.Editor getEditor() {
        return sharedPreferences.edit();
    }


}
