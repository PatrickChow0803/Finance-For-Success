package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.foundation.layout.*
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
import com.patrickchow.financeforsuccess.dataclass.ModalSheetInformation
import com.patrickchow.financeforsuccess.ui.common.CalculateButton
import com.patrickchow.financeforsuccess.ui.common.CalculatedText
import com.patrickchow.financeforsuccess.ui.common.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
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
                modalSheetInfo = ModalSheetInformation(title = "principle", description = "does this"),
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.rate,
                onValueChange = { viewModel.rate = it },
                label = "Interest Rate (%)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The percentage of interest to be applied."
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.time,
                onValueChange = { viewModel.time = it },
                label = "Time (years)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The time period in years."
            )

            Spacer(modifier = Modifier.height(16.dp))

            CalculateButton(onClick = { viewModel.calculateInterest() })

            Spacer(modifier = Modifier.height(16.dp))

            CalculatedText(text = "Calculated Interest:", result = viewModel.result)
            CalculatedText(text = "Calculated Total:", result = viewModel.total)
        }
    }
}

