package io.neowise.walletscompose.remote;

import io.neowise.walletscompose.remote.api.WalletApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val accessKey = "wallet:6CFBE29E52CF5494AF8836B2CBBCB"

    private val client by lazy {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(AccessKeyInterceptor(accessKey))
            .build()

        Retrofit.Builder()
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://62.113.108.69:4551/api/v1/")
            .build()
    }

    val walletApi by lazy {
        client.create(WalletApi::class.java)
    }
}
