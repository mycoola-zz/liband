package com.liband


import android.content.Context
import androidx.multidex.MultiDexApplication
import com.liband.constants.Constants.MAX_STALE
import com.liband.utils.NetUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


class App : MultiDexApplication() {
    private var retrofitAdapter: Retrofit? = null


    override fun onCreate() {
        super.onCreate()
        app = this
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
            builder.connectTimeout(300, TimeUnit.SECONDS)
            builder.readTimeout(300, TimeUnit.SECONDS)
            builder.writeTimeout(300, TimeUnit.SECONDS)
            retrofitAdapter = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build()
        }
        return retrofitAdapter
    }


    fun getRetrofit(baseUrl: String): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(AcceptJsonInterceptor())
                .addNetworkInterceptor(ResponseCacheInterceptor())
                .addInterceptor(OfflineResponseCacheInterceptor(this.applicationContext))
                .cache(NetUtil.getNetworkCache(this.applicationContext))
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
        return retrofit!!
    }


    private class ResponseCacheInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalResponse = chain.proceed(chain.request())
            return if (chain.request().method() == "GET") {
                originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=0")
                        .build()
            } else {
                originalResponse
            }
        }
    }

    private class AcceptJsonInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalResponse = chain.proceed(chain.request())
            return originalResponse.newBuilder()
                    .header("Content-Type", "application/json")
                    .build()
        }
    }

    private class OfflineResponseCacheInterceptor(val applicationContext: Context) : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            if (!NetUtil.isNetworkAvailable(this.applicationContext)) {
                if (request.method() == "GET") {
                    request = request.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=$MAX_STALE")
                            .build()
                }
            }
            return chain.proceed(request)
        }
    }

    companion object {
        lateinit var app: App
            private set
    }


}