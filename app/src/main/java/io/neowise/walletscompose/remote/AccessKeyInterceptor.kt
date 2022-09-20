package io.neowise.walletscompose.remote

import okhttp3.Interceptor
import okhttp3.Response

class AccessKeyInterceptor(private val accessKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("X-Access-Key", accessKey)
                .build()
        )
    }
}