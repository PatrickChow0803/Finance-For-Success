package com.patrickchow.financeforsuccess.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.patrickchow.financeforsuccess.navigation.ScreenType

@Composable
fun WIP (functionType: ScreenType) {
    Box(
    modifier = Modifier
    .fillMaxSize(), // Fill the entire screen
    contentAlignment = Alignment.Center // Center content inside the Box
    ) {
        Text(
            text = "${functionType.name} is a Work in Progress!",
            fontSize = 20.sp,
            color = Color.Gray
        )
    }
}