package com.patrickchow.financeforsuccess.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.dataclass.calculatorItems
import com.patrickchow.financeforsuccess.ui.common.CalculatorCard
import com.patrickchow.financeforsuccess.ui.common.text.HeaderText
import com.patrickchow.financeforsuccess.ui.extensions.customScrollableColumn

@Composable
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFEB3B),
                        Color(0xFFFFC107),
                        Color(0xFFFFA726),
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .customScrollableColumn(scrollState, PaddingValues(4.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(
                text = stringResource(id = R.string.home_screen_title),
            )

            for (item in calculatorItems) {
                CalculatorCard(
                    functionName = item.title,
                    imageResId = item.icon,
                    navController = navController,
                    screenType = item.screen
                )
            }
        }
    }

}