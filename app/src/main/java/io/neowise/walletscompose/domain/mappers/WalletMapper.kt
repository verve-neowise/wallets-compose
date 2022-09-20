package io.neowise.walletscompose.domain.mappers

import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.remote.dto.WalletDto

fun Wallet.toDto() = WalletDto(
        id = id,
        name = name,
        balance = balance,
        color = color.name,
        date = date
)

fun WalletDto.toModel() = Wallet(
    id = id,
    name = name,
    date = date,
    color = Wallet.Color.valueOf(color),
    balance = balance
    )
