package com.patrickchow.financeforsuccess.ui.common.text

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(text: String) {
    BasicText(
        text = text,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121),
            letterSpacing = 1.sp
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    )
}