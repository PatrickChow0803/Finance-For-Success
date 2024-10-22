package com.patrickchow.financeforsuccess.ui.screens.futurecalculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.dataclass.CalculatorItem
import com.patrickchow.financeforsuccess.dataclass.ModalSheetType
import com.patrickchow.financeforsuccess.dataclass.getModalSheetTypeIndex
import com.patrickchow.financeforsuccess.dataclass.listOfModalSheetInformation
import com.patrickchow.financeforsuccess.ui.common.AppScaffold
import com.patrickchow.financeforsuccess.ui.common.CalculateButton
import com.patrickchow.financeforsuccess.ui.common.CalculatedText
import com.patrickchow.financeforsuccess.ui.common.NumberTextField
import com.patrickchow.financeforsuccess.ui.common.PaymentTypeRadioButtonGroup
import com.patrickchow.financeforsuccess.ui.common.UIUtility

@Composable
fun FutureValueScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: FutureValueViewModel = viewModel()

    AppScaffold (
        title = calculatorItem.title,
        navController = navController,
    ) {
        NumberTextField(
            value = viewModel.rate.value,
            onValueChange = { viewModel.onRateChange(it) },
            label = stringResource(R.string.interest_rate_label),
            tooltipMessage = stringResource(R.string.interest_rate_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)]
        )

        UIUtility.SmallSpacer()

        NumberTextField(
            value = viewModel.nper.value,
            onValueChange = { viewModel.onTimeChange(it) },
            label = stringResource(R.string.nper_label),
            tooltipMessage = stringResource(R.string.nper_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Nper)]
        )

        UIUtility.SmallSpacer()

        NumberTextField(
            value = viewModel.payment.value,
            onValueChange = { viewModel.onPaymentChange(it) },
            label = stringResource(R.string.payment_amount_label),
            tooltipMessage = stringResource(R.string.payment_amount_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Pmt)]
        )

        UIUtility.SmallSpacer()

        NumberTextField(
            value = viewModel.presentValue.value,
            onValueChange = { viewModel.onPresentValueChange(it) },
            label = stringResource(R.string.present_value_label),
            tooltipMessage = stringResource(R.string.present_value_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.PV)]
        )

        UIUtility.SmallSpacer()

        PaymentTypeRadioButtonGroup(
            selectedOption = viewModel.paymentType.value,
            onOptionSelected = { viewModel.onPaymentTypeChange(it) }
        )

        UIUtility.MediumSpacer()

        CalculateButton(
            onClick = { viewModel.calculateFutureValue() },
            displayText = stringResource(R.string.calculate_future_value)
        )

        UIUtility.MediumSpacer()

        CalculatedText(
            text = stringResource(R.string.calculated_future_value),
            result = viewModel.result.value
        )
    }
}
