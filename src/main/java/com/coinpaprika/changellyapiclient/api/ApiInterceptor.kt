/*
 * Created by Piotr Kostecki on 11/21/19 6:34 PM
 */

package com.coinpaprika.changellyapiclient.api

import com.coinpaprika.changellyapiclient.BuildConfig
import com.coinpaprika.changellyapiclient.extensions.hmac
import com.coinpaprika.changellyapiclient.extensions.string
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val original = chain.request()
        val sign = chain.request().body!!.string().hmac()
        val request = original.newBuilder()
            .header("sign", sign)
            .header("api-key", BuildConfig.API_KEY)
            .method(original.method, original.body)
            .build()
        chain.proceed(request)
    }
}