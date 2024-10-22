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
import com.patrickchow.financeforsuccess.ui.common.NumberTextField
import com.patrickchow.financeforsuccess.ui.common.UIUtility

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
            NumberTextField(
                value = viewModel.principal.value,
                onValueChange = { viewModel.onPrincipalChange(it) },
                label = "Principal Amount",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The initial amount of money on which interest is calculated.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Principal)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.rate.value,
                onValueChange = { viewModel.onRateChange(it) },
                label = "Interest Rate (%)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The percentage of interest to be applied.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.time.value,
                onValueChange = { viewModel.onTimeChange(it) },
                label = "Time (years)",
                keyboardType = KeyboardType.Number,
                tooltipMessage = "The time period in years.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Time)],
            )

            UIUtility.MediumSpacer()

            CalculateButton(onClick = { viewModel.calculateCompoundInterest(numberOfCompoundPerYear = 1) }, displayText = "Compound Interest")
            CalculateButton(onClick = { viewModel.calculateInterest() }, displayText = "Simple Interest")

            Spacer(modifier = Modifier.height(16.dp))
            UIUtility.MediumSpacer()

            CalculatedText(text = "Calculated Interest:", result = viewModel.result.value)
            UIUtility.SmallSpacer()
            CalculatedText(text = "Calculated Total:", result = viewModel.total.value)
        }
    }
}
