package io.neowise.walletscompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.neowise.walletscompose.domain.model.Wallet
import io.neowise.walletscompose.ui.theme.Dark
import io.neowise.walletscompose.ui.theme.Purple500
import io.neowise.walletscompose.ui.theme.Purple700
import io.neowise.walletscompose.ui.theme.Red

@Composable
fun WalletItem(wallet: Wallet, onTopUp: () -> Unit = { }, onDelete: () -> Unit = { }) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 15.dp
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = wallet.name,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = wallet.color
                )
                Text(text = wallet.date)
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = wallet.balance.toString(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 36.sp),
                color = Dark
            )

            Row(modifier = Modifier.fillMaxWidth()) {

                Button(
                    onClick = onTopUp
                ) {
                    Text(text = "Top Up")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    colors = ButtonDefaults.textButtonColors(backgroundColor = Red, contentColor = Color.White),
                    onClick = onDelete,
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    val wallet = Wallet(
        name = "Bank",
        color = Red,
        date = "02.10.2022",
        balance = 150.0
    )

    WalletItem(wallet = wallet)
}