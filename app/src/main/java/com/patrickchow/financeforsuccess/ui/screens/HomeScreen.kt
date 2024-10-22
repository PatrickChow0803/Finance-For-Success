package com.patrickchow.financeforsuccess.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.dataclass.calculatorItems
import com.patrickchow.financeforsuccess.ui.common.CalculatorCard

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.home_screen_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Display calculator cards
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