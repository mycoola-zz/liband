package com.liband;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.liband.utils.LangUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application implements Application.ActivityLifecycleCallbacks {
    private static App app;
    boolean isTempLoggedIn = false;
    private Retrofit retrofitAdapter;
    private Retrofit retrofitAdapterSecond;

    public static App getApp() {
        return app;
    }

    public boolean isTempLoggedIn() {
        return isTempLoggedIn;
    }

    public void setTempLoggedIn(boolean tempLoggedIn) {
        isTempLoggedIn = tempLoggedIn;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        registerActivityLifecycleCallbacks(this);
    }


    public void setLanguage() {
        getApp().getResources().updateConfiguration(LangUtils.getLocal(getApp()), getApp().getResources().getDisplayMetrics());
    }

    public boolean isNavigationRunning() {
        boolean isNavigationRunning = false;
        return isNavigationRunning;
    }

    public Retrofit getRetrofitAdapter(String baseUrl) {
        if (retrofitAdapter == null) {
            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            final okhttp3.OkHttpClient okHttpClient = new OkHttpClient();
            final OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.addInterceptor(logging);
            builder.addInterceptor(chain -> {

                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
            builder.connectTimeout(240, TimeUnit.SECONDS);
            builder.readTimeout(240, TimeUnit.SECONDS);
            builder.writeTimeout(240, TimeUnit.SECONDS);
            retrofitAdapter = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();
        }
        return retrofitAdapter;
    }

    public Retrofit getServiceRetrofitAdapter(String baseUrl) {
        if (retrofitAdapter == null) {
            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            final okhttp3.OkHttpClient okHttpClient = new OkHttpClient();
            final OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.addInterceptor(logging);
            builder.addInterceptor(chain -> {

                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
            builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
            builder.readTimeout(3000, TimeUnit.MILLISECONDS);
            builder.writeTimeout(3000, TimeUnit.MILLISECONDS);
            retrofitAdapter = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();

        }
        return retrofitAdapter;
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}