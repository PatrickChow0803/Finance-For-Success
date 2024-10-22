package com.patrickchow.financeforsuccess.ui.screens.tipscalculator

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
import com.patrickchow.financeforsuccess.dataclass.ModalSheetType
import com.patrickchow.financeforsuccess.dataclass.getModalSheetTypeIndex
import com.patrickchow.financeforsuccess.dataclass.listOfModalSheetInformation
import com.patrickchow.financeforsuccess.ui.common.CustomAppBar
import com.patrickchow.financeforsuccess.ui.common.CalculateButton
import com.patrickchow.financeforsuccess.ui.common.CalculatedText
import com.patrickchow.financeforsuccess.ui.common.NumberTextField
import com.patrickchow.financeforsuccess.ui.common.UIUtility

@Composable
fun TipsCalculatorScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: TipsCalculatorViewModel = viewModel()

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
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            NumberTextField(
                value = viewModel.billAmount.value,
                onValueChange = { viewModel.onBillAmountChange(it) },
                label = "Bill Amount",
                tooltipMessage = "Enter the total bill amount.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Bill)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.tipPercentage.value,
                onValueChange = { viewModel.onTipPercentageChange(it) },
                label = "Tip Percentage (%)",
                tooltipMessage = "Enter the desired tip percentage.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.TipPercent)],
            )

            UIUtility.MediumSpacer()

            CalculateButton(onClick = { viewModel.calculateTip() })

            UIUtility.MediumSpacer()

            CalculatedText(text = "Calculated Tip:", result = viewModel.calculatedTip.value)
            CalculatedText(text = "Total Amount:", result = viewModel.totalAmount.value)
        }
    }
}
