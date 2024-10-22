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
import com.patrickchow.financeforsuccess.dataclass.ModalSheetType
import com.patrickchow.financeforsuccess.dataclass.getModalSheetTypeIndex
import com.patrickchow.financeforsuccess.dataclass.listOfModalSheetInformation
import com.patrickchow.financeforsuccess.ui.common.CalculateButton
import com.patrickchow.financeforsuccess.ui.common.CalculatedText
import com.patrickchow.financeforsuccess.ui.common.CustomTextField

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
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            CustomTextField(
                value = viewModel.principal.value,
                onValueChange = { viewModel.onPrincipalChange(it) },
                label = "Principal Amount",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The initial amount of money on which interest is calculated.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Principal)],
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.rate.value,
                onValueChange = { viewModel.onRateChange(it) },
                label = "Interest Rate (%)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The percentage of interest to be applied.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)],
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = viewModel.time.value,
                onValueChange = { viewModel.onTimeChange(it) },
                label = "Time (years)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The time period in years.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Time)],
            )

            Spacer(modifier = Modifier.height(16.dp))

            CalculateButton(onClick = { viewModel.calculateInterest() }, displayText = "Simple Interest")
            CalculateButton(onClick = { viewModel.calculateCompoundInterest(numberOfCompoundPerYear = 1) }, displayText = "Compound Interest")

            Spacer(modifier = Modifier.height(16.dp))

            CalculatedText(text = "Calculated Interest:", result = viewModel.result.value)
            CalculatedText(text = "Calculated Total:", result = viewModel.total.value)
        }
    }
}
