package io.neowise.walletscompose.remote.dto

import io.neowise.walletscompose.domain.model.Wallet

data class WalletDto(
    val id: Int,
    val name: String,
    val date: String,
    val color: String,
    val balance: Double
) {

    fun toModel() = Wallet(
        id = id,
        name = name,
        date = date,
        color = Wallet.Color.valueOf(color),
        balance = balance
    )
}