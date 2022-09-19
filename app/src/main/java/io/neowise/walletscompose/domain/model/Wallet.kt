package io.neowise.walletscompose.domain.model

import androidx.compose.ui.graphics.Color

data class Wallet(
    val id: Int,
    val name: String,
    val color: Color,
    val date: String,
    val balance: Double,
) {

    constructor(
        name: String,
        color: Color,
        date: String,
        balance: Double
    ) : this(-1, name, color, date, balance)
}