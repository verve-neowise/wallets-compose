package io.neowise.walletscompose.remote.api;

import io.neowise.walletscompose.remote.dto.BaseResponse
import io.neowise.walletscompose.remote.dto.WalletDto
import io.neowise.walletscompose.remote.dto.WalletList
import retrofit2.http.GET;
import retrofit2.http.POST

public interface WalletApi {

    @GET("wallets")
    suspend fun allWallets(): WalletList

    @POST("wallets")
    suspend fun addWallet(dto: WalletDto): BaseResponse
}
