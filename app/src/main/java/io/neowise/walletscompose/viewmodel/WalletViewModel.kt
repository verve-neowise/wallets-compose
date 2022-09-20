package io.neowise.walletscompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import io.neowise.walletscompose.domain.repository.WalletRepository
import io.neowise.walletscompose.remote.Response
import io.neowise.walletscompose.remote.RetrofitFactory
import io.neowise.walletscompose.remote.dto.WalletList
import io.neowise.walletscompose.remote.repository.WalletRepositoryImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WalletViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WalletRepository = WalletRepositoryImpl(RetrofitFactory.walletApi)

    var walletsState = mutableStateOf<Response<WalletList>>(Response.Loading)
        private set

    fun fetchWallets() {
        viewModelScope.launch {
            repository.getWallets().collect {
                walletsState.setValue(it)
            }
        }
    }
}