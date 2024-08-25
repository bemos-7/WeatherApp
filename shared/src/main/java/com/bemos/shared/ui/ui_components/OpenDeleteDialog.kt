package com.bemos.shared.ui.ui_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun OpenDeleteDialog(
    isTrueValue: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit
) {
    if (isTrueValue) {
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            title = { Text(text = "Подтверждения действия") },
            text = { Text(text = "Вы действительно хотите удалить выбранный элемент") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmButton()
                    }
                ) {
                    Text(text = "Удалить")
                }
            }
        )
    }
}