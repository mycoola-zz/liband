package com.liband


import android.app.Application
import com.liband.utils.LangUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class App : Application() {
    var isTempLoggedIn = false
    private var retrofitAdapter: Retrofit? = null
    private val retrofitAdapterSecond: Retrofit? = null

    val isNavigationRunning: Boolean
        get() = false

    override fun onCreate() {
        super.onCreate()
        app = this
    }


    fun setLanguage() {
        app!!.resources.updateConfiguration(LangUtils.getLocal(app!!), app!!.resources.displayMetrics)
    }

    fun getRetrofitAdapter(baseUrl: String): Retrofit? {
        if (retrofitAdapter == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient()
            val builder = okHttpClient.newBuilder()
            builder.addInterceptor(logging)
            builder.addInterceptor { chain ->

                val original = chain.request()
                val originalHttpUrl = original.url()

                val url = originalHttpUrl.newBuilder()
                        .build()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                        .url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
            builder.connectTimeout(240, TimeUnit.SECONDS)
            builder.readTimeout(240, TimeUnit.SECONDS)
            builder.writeTimeout(240, TimeUnit.SECONDS)
            retrofitAdapter = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build()
        }
        return retrofitAdapter
    }

    fun getServiceRetrofitAdapter(baseUrl: String): Retrofit? {
        if (retrofitAdapter == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient()
            val builder = okHttpClient.newBuilder()
            builder.addInterceptor(logging)
            builder.addInterceptor { chain ->

                val original = chain.request()
                val originalHttpUrl = original.url()

                val url = originalHttpUrl.newBuilder()
                        .build()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                        .url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
            builder.connectTimeout(3000, TimeUnit.MILLISECONDS)
            builder.readTimeout(3000, TimeUnit.MILLISECONDS)
            builder.writeTimeout(3000, TimeUnit.MILLISECONDS)
            retrofitAdapter = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build()

        }
        return retrofitAdapter
    }

    companion object {
        lateinit var app: App
            private set
    }


}