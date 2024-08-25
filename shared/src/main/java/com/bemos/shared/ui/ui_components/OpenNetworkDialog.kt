package com.bemos.shared.ui.ui_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun OpenNetworkDialog(
    networkState: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit
) {
    if (!networkState) {
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            title = { Text(text = "Нет подключения к Интернету") },
            text = { Text(text = "Проверьте подключение к Интернету и повторите попытку") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmButton()
                    }
                ) {
                    Text(text = "Повторите попытку")
                }
            }
        )
    }
}