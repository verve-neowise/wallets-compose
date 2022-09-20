package io.neowise.walletscompose.domain.repository

import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.remote.Response
import io.neowise.walletscompose.remote.dto.BaseResponse
import io.neowise.walletscompose.remote.dto.WalletList
import kotlinx.coroutines.flow.Flow

interface WalletRepository {
    fun getWallets() : Flow<Response<WalletList>>
    fun createWallet(wallet: Wallet): Flow<Response<BaseResponse>>
}
