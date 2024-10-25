package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorCardText(
    text: String,
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = Color.Black,
        fontFamily = FontFamily.Serif
    )
}