package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.patrickchow.financeforsuccess.dataclass.ModalSheetInformation
import com.patrickchow.financeforsuccess.util.CustomRegex

/**
 *  The standard number input field for this app.
 *  Makes is so that only numbers, a single decimal, and two decimal places are allowed.
 *  Also includes a tooltip to help users understand a field that opens up a bottom sheet to explain
 *  */

@Composable
fun NumberTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    tooltipMessage: String? = null,
    modalSheetInfo: ModalSheetInformation? = null,
    modifier: Modifier = Modifier
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    val regex = CustomRegex.dollarRegex

    Column {
        TextField(
            value = value,
            onValueChange = { onValueChange ->
                // Validate the new value against the regex
                if (regex.matcher(onValueChange).matches()) {
                    onValueChange(onValueChange) // Only update if the new value is valid
                }
            },
            label = { Text(label) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = modifier.fillMaxWidth(),
            trailingIcon = {
                if (tooltipMessage != null) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Info",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            showBottomSheet = true // Show the bottom sheet when the icon is clicked
                        }
                    )
                }
            }
        )

        if (showBottomSheet && modalSheetInfo != null) {
            ExplanationBottomSheet(
                modalSheetInfo = modalSheetInfo,
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}
