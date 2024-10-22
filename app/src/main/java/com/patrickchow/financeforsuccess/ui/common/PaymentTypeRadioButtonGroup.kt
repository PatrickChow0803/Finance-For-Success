package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.patrickchow.financeforsuccess.R

@Composable
fun PaymentTypeRadioButtonGroup(
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(stringResource(R.string.payment_type_label))

        RadioButtonOption(
            selected = selectedOption == 0,
            onClick = { onOptionSelected(0) },
            text = stringResource(R.string.payment_type_end)
        )

        RadioButtonOption(
            selected = selectedOption == 1,
            onClick = { onOptionSelected(1) },
            text = stringResource(R.string.payment_type_beginning)
        )
    }
}

@Composable
fun RadioButtonOption(
    selected: Boolean,
    onClick: () -> Unit,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text)
    }
}