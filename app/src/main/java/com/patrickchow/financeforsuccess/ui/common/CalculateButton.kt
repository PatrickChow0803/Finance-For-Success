package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CalculateButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Calculate")
    }
}
