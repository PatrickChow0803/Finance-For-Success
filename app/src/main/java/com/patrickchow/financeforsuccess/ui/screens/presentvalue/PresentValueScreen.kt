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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.res.stringResource
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.dataclass.ModalSheetType
import com.patrickchow.financeforsuccess.dataclass.getModalSheetTypeIndex
import com.patrickchow.financeforsuccess.dataclass.listOfModalSheetInformation
import com.patrickchow.financeforsuccess.ui.common.AppScaffold
import com.patrickchow.financeforsuccess.ui.common.CalculateButton
import com.patrickchow.financeforsuccess.ui.common.CalculatedText
import com.patrickchow.financeforsuccess.ui.common.NumberTextField
import com.patrickchow.financeforsuccess.ui.common.UIUtility
import com.patrickchow.financeforsuccess.ui.extensions.customScrollableColumn

@Composable
fun PresentValueScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: PresentValueViewModel = viewModel()
    val scrollState = rememberScrollState()

    AppScaffold(
        title = calculatorItem.title, navController = navController
    ) { innerPadding ->
        Column(
            modifier = Modifier.customScrollableColumn(scrollState, innerPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            NumberTextField(
                value = viewModel.rate.value,
                onValueChange = { viewModel.onRateChange(it) },
                label = stringResource(R.string.interest_rate_label),
                tooltipMessage = stringResource(R.string.interest_rate_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.nper.value,
                onValueChange = { viewModel.onTimeChange(it) },
                label = stringResource(R.string.nper_label),
                tooltipMessage = stringResource(R.string.nper_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Nper)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.payment.value,
                onValueChange = { viewModel.onPaymentChange(it) },
                label = stringResource(R.string.payment_amount_label),
                tooltipMessage = stringResource(R.string.payment_amount_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Pmt)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.futureValue.value,
                onValueChange = { viewModel.onFutureValueChange(it) },
                label = stringResource(R.string.future_value_label),
                tooltipMessage = stringResource(R.string.future_value_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.FV)],
            )

            UIUtility.SmallSpacer()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(stringResource(R.string.payment_type_label))
                RadioButton(
                    selected = viewModel.paymentType.value == 0,
                    onClick = { viewModel.onPaymentTypeChange(0) }
                )
                Text(stringResource(R.string.payment_type_end))
                RadioButton(
                    selected = viewModel.paymentType.value == 1,
                    onClick = { viewModel.onPaymentTypeChange(1) }
                )
                Text(stringResource(R.string.payment_type_beginning))
            }

            UIUtility.MediumSpacer()

            CalculateButton(onClick = { viewModel.calculatePresentValue() }, displayText = stringResource(
                R.string.calculate_present_value))

            UIUtility.MediumSpacer()

            CalculatedText(text = stringResource(R.string.calculated_present_value_label), result = viewModel.result.value)
        }
    }
}
