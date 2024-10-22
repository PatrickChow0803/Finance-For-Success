package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CalculateButton(onClick: () -> Unit, displayText: String? = null) {
    Button(onClick = onClick) {
        Text("Calculate${displayText?.let { " $it" } ?: ""}")
    }
}
