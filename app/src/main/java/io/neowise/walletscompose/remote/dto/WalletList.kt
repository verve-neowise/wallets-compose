package io.neowise.walletscompose.remote.dto

data class WalletList(
    val wallets: List<WalletDto>
): BaseResponse()