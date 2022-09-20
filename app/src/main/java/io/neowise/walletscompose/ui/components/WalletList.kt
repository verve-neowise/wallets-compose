package io.neowise.walletscompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.ui.theme.Red

@Composable
fun WalletList(wallets: List<Wallet>) {

    LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)) {
        items(
            items = wallets,
            itemContent = {
                WalletItem(wallet = it)
            }
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    val wallets = listOf(
        Wallet(name = "Bank 1", color = Wallet.Color.RED, date = "01.03.2023", balance = 150.0),
        Wallet(name = "Bank 2", color = Wallet.Color.GREEN,  date = "01.03.2023", balance = 350.0),
        Wallet(name = "Bank 3", color = Wallet.Color.BLUE,  date = "01.03.2023", balance = 250.0),
        Wallet(name = "Bank 4", color = Wallet.Color.YELLOW,  date = "01.03.2023", balance = 1100.0),
    )

    WalletList(wallets = wallets)
}
