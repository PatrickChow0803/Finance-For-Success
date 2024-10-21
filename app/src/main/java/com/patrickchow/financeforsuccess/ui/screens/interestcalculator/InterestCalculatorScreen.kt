package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.dataclass.CalculatorItem
import com.patrickchow.financeforsuccess.ui.common.CustomAppBar
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


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
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.principal,
                onValueChange = {
                    // Only update if the input is a number
                    if (it.all { char -> char.isDigit() || char == '.' }) {
                        viewModel.principal = it
                    }
                },
                label = { Text("Principal Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.rate,
                onValueChange = {
                    // Only update if the input is a number
                    if (it.all { char -> char.isDigit() || char == '.' }) {
                        viewModel.rate = it
                    }
                },
                label = { Text("Interest Rate (%)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.time,
                onValueChange = {
                    // Only update if the input is a number
                    if (it.all { char -> char.isDigit() }) {
                        viewModel.time = it
                    }
                },
                label = { Text("Time (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { viewModel.calculateInterest() }) {
                Text("Calculate")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Calculated Interest: ${viewModel.result}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Total Value: ${viewModel.total}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
