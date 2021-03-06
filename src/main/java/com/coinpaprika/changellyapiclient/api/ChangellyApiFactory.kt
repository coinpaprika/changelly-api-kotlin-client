/*
 * Created by Piotr Kostecki on 4/23/19 11:50 AM
 */

package com.coinpaprika.changellyapiclient.api

import com.coinpaprika.changellyapiclient.BuildConfig
import com.coinpaprika.changellyapiclient.extensions.hmac
import com.coinpaprika.changellyapiclient.extensions.string
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ChangellyApiFactory {
    companion object {
        private const val BASE_URL = "https://api.changelly.com"
    }

    fun client(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                createClient()
                    .addInterceptor(ApiInterceptor())
                    .addInterceptor(createLoggingInterceptor())
                    .build()
            )
            .build()
    }

    private fun createClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
            .writeTimeout(20000, TimeUnit.MILLISECONDS)
            .readTimeout(10000, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .connectTimeout(15000, TimeUnit.MILLISECONDS)
            .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
    }

    private fun createLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}