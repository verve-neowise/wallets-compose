package io.neowise.walletscompose.domain.model

import androidx.compose.ui.graphics.Color
import io.neowise.walletscompose.ui.theme.Purple700
import io.neowise.walletscompose.ui.theme.Red
import io.neowise.walletscompose.ui.theme.Yellow

typealias UIColor = Color

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

    enum class Color(val color: UIColor) {
        RED(Red),
        YELLOW(Yellow),
        BLUE(Purple700),
        GREEN(UIColor.Green)
    }
}