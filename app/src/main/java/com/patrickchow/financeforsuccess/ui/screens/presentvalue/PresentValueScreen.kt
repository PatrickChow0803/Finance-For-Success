package com.patrickchow.financeforsuccess.ui.screens.presentvalue

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun PresentValueScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: PresentValueViewModel = viewModel()
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
                value = viewModel.rate.value,
                onValueChange = { viewModel.onRateChange(it) },
                label = "Interest Rate (%)",
                tooltipMessage = "The percentage of interest applied annually.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.nper.value,
                onValueChange = { viewModel.onTimeChange(it) },
                label = "Number of Payments (Nper)",
                tooltipMessage = "The total number of payments.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Nper)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.payment.value,
                onValueChange = { viewModel.onPaymentChange(it) },
                label = "Payment Amount",
                tooltipMessage = "The amount of each payment.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Pmt)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.futureValue.value,
                onValueChange = { viewModel.onFutureValueChange(it) },
                label = "Future Value (Optional)",
                tooltipMessage = "The value you want to calculate the present value for.",
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.FV)],
            )

            UIUtility.SmallSpacer()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Payment Type:")
                RadioButton(
                    selected = viewModel.paymentType.value == 0,
                    onClick = { viewModel.onPaymentTypeChange(0) }
                )
                Text("End")
                RadioButton(
                    selected = viewModel.paymentType.value == 1,
                    onClick = { viewModel.onPaymentTypeChange(1) }
                )
                Text("Beginning")
            }

            UIUtility.MediumSpacer()

            CalculateButton(onClick = { viewModel.calculatePresentValue() }, displayText = "Calculate Present Value")

            UIUtility.MediumSpacer()

            CalculatedText(text = "Calculated Present Value:", result = viewModel.result.value)
        }
    }
}
