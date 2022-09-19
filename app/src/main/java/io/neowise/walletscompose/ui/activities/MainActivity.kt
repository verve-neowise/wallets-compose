package io.neowise.walletscompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.ui.components.WalletList
import io.neowise.walletscompose.ui.theme.Dark
import io.neowise.walletscompose.ui.theme.Red
import io.neowise.walletscompose.ui.theme.WalletsComposeTheme
import io.neowise.walletscompose.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletsComposeTheme {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {
    Surface(
        modifier = Modifier
        .fillMaxSize()
        .background(color = Dark),
        color = Dark
    ) {

        val wallets = listOf(
            Wallet(name = "Bank 1", color = Red, date = "01.03.2023", balance = 150.0),
            Wallet(name = "Bank 2", color = Color.Green,  date = "01.03.2023", balance = 350.0),
            Wallet(name = "Bank 3", color = Color.Blue,  date = "01.03.2023", balance = 250.0),
            Wallet(name = "Bank 4", color = Yellow,  date = "01.03.2023", balance = 1100.0),
        )

        WalletList(wallets = wallets)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Content()
}
