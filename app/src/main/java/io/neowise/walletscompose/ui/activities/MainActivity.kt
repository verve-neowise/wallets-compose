package io.neowise.walletscompose.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.remote.Response
import io.neowise.walletscompose.ui.components.WalletList
import io.neowise.walletscompose.ui.theme.Dark
import io.neowise.walletscompose.ui.theme.Red
import io.neowise.walletscompose.ui.theme.WalletsComposeTheme
import io.neowise.walletscompose.ui.theme.Yellow
import io.neowise.walletscompose.viewmodel.WalletViewModel


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<WalletViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val state = remember { viewModel.walletsState }

            WalletsComposeTheme {
                when(state) {
                    is Response.Loading -> {
                        Text(
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            text = "Loading"
                        )
                    }
                    is Response.Success -> {
                        val wallets = state.data.wallets.map {
                            it.toModel()
                        }

                        Content(wallets = wallets)
                    }
                    is Response.Failure -> {
                        Log.e("ERROR", "onCreate: ", state.exception)
                    }
                }
            }
        }
    }
}

@Composable
private fun Content(wallets: List<Wallet>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark),
        color = Dark
    ) {

        WalletList(wallets = wallets)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
}
