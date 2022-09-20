package io.neowise.walletscompose.remote.repository

import io.neowise.walletscompose.domain.mappers.toDto
import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.domain.repository.WalletRepository
import io.neowise.walletscompose.remote.Response
import io.neowise.walletscompose.remote.api.WalletApi
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class WalletRepositoryImpl(private val walletApi: WalletApi) : WalletRepository {

    override fun getWallets() = callApi {
        walletApi.allWallets()
    }

    override fun createWallet(wallet: Wallet) = callApi {
        walletApi.addWallet(wallet.toDto())
    }

    private fun <T> callApi(apiCall: suspend () -> T) = flow {
        try {
            emit(Response.Loading)
            val result = apiCall()
            emit(Response.Success(result))
        }
        catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }
}