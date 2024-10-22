package com.patrickchow.financeforsuccess.ui.screens.tipscalculator

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
import com.patrickchow.financeforsuccess.ui.common.UIUtility

@Composable
fun TipsCalculatorScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: TipsCalculatorViewModel = viewModel()

    AppScaffold(
        title = calculatorItem.title,
        navController = navController,
    ) {
        NumberTextField(
            value = viewModel.billAmount.value,
            onValueChange = { viewModel.onBillAmountChange(it) },
            label = stringResource(R.string.bill_amount_label),
            tooltipMessage = stringResource(R.string.bill_amount_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Bill)]
        )

        UIUtility.SmallSpacer()

        NumberTextField(
            value = viewModel.tipPercentage.value,
            onValueChange = { viewModel.onTipPercentageChange(it) },
            label = stringResource(R.string.tip_percentage_label),
            tooltipMessage = stringResource(R.string.tip_percentage_tooltip),
            modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.TipPercent)]
        )

        UIUtility.MediumSpacer()

        CalculateButton(onClick = { viewModel.calculateTip() })

        UIUtility.MediumSpacer()

        CalculatedText(text = stringResource(R.string.calculated_tip_label), result = viewModel.calculatedTip.value)
        UIUtility.SmallSpacer()
        CalculatedText(text = stringResource(R.string.total_amount_label), result = viewModel.totalAmount.value)
    }
}
