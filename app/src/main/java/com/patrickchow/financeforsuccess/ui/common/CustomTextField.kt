package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.dataclass.CalculatorItem
import com.patrickchow.financeforsuccess.ui.screens.interestcalculator.CustomTextField
import com.patrickchow.financeforsuccess.ui.screens.interestcalculator.InterestCalculatorViewModel

@Composable
fun InterestCalculatorScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: InterestCalculatorViewModel = viewModel()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CustomAppBar(
                title = calculatorItem.title,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            CustomTextField(
                value = viewModel.principal,
                onValueChange = { viewModel.principal = it },
                label = "Principal Amount",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The initial amount of money on which interest is calculated.",
                bottomSheetContent = "The principal amount is the starting amount of money that you invest or borrow, which will accrue interest over time."
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.rate,
                onValueChange = { viewModel.rate = it },
                label = "Interest Rate (%)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The percentage of interest to be applied.",
                bottomSheetContent = "The interest rate represents the percentage of the principal that will be paid as interest over a set period."
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.time,
                onValueChange = { viewModel.time = it },
                label = "Time (years)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The time period in years.",
                bottomSheetContent = "The time in years is the duration over which the interest will be applied to the principal."
            )

            Spacer(modifier = Modifier.height(16.dp))

            CalculateButton(onClick = { viewModel.calculateInterest() })

            Spacer(modifier = Modifier.height(16.dp))

            CalculatedText(text = "Calculated Interest:", result = viewModel.result)
            CalculatedText(text = "Calculated Total:", result = viewModel.total)
        }
    }
}

