package com.patrickchow.financeforsuccess.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.dataClass.CalculatorItem
import com.patrickchow.financeforsuccess.navigation.ScreenType
import com.patrickchow.financeforsuccess.ui.common.CustomAppBar

@Composable
fun WIP(calculatorItem: CalculatorItem, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Custom App Bar with Back Button
        CustomAppBar(
            title = calculatorItem.title, // Set a title for the app bar
            onBackClick = { navController.popBackStack() } // Handle back navigation
        )

        // Center content inside a Box below the App Bar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), // Fill the remaining screen space
            contentAlignment = Alignment.Center // Center content inside the Box
        ) {
            Text(
                text = "${calculatorItem.title} is a Work in Progress!",
                fontSize = 20.sp,
                color = Color.Gray
            )
        }
    }
}