package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme

@Composable
fun CalculatedText(text:String, result: String) {

    val displayedText = if (result.isNotEmpty()) {
        "$text \$$result"
    } else {
        text
    }

    Text(
        text = displayedText,
        style = MaterialTheme.typography.bodyLarge
    )
}