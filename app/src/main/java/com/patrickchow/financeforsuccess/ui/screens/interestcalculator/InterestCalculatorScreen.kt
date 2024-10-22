package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.foundation.layout.*
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
fun InterestCalculatorScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: InterestCalculatorViewModel = viewModel()
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
                value = viewModel.principal.value,
                onValueChange = { viewModel.onPrincipalChange(it) },
                label = stringResource(id = R.string.principal_amount_label),
                tooltipMessage = stringResource(id = R.string.principal_amount_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Principal)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.rate.value,
                onValueChange = { viewModel.onRateChange(it) },
                label = stringResource(id = R.string.interest_rate_label),
                tooltipMessage = stringResource(id = R.string.interest_rate_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Interest)],
            )

            UIUtility.SmallSpacer()

            NumberTextField(
                value = viewModel.time.value,
                onValueChange = { viewModel.onTimeChange(it) },
                label = stringResource(id = R.string.time_label),
                tooltipMessage = stringResource(id = R.string.time_tooltip),
                modalSheetInfo = listOfModalSheetInformation[getModalSheetTypeIndex(ModalSheetType.Time)],
            )

            UIUtility.MediumSpacer()

            CalculateButton(onClick = { viewModel.calculateCompoundInterest(numberOfCompoundPerYear = 1) }, displayText = stringResource(id = R.string.calculate_compound_interest))
            CalculateButton(onClick = { viewModel.calculateInterest() }, displayText = stringResource(id = R.string.calculate_simple_interest))

            Spacer(modifier = Modifier.height(16.dp))
            UIUtility.MediumSpacer()

            CalculatedText(text = stringResource(id = R.string.calculated_interest_label), result = viewModel.result.value)
            UIUtility.SmallSpacer()
            CalculatedText(text = stringResource(id = R.string.calculated_total_label), result = viewModel.total.value)

        }
    }
}
