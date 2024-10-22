package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class InterestCalculatorViewModel : ViewModel() {
    var principal by mutableStateOf("")
    var rate by mutableStateOf("")
    var time by mutableStateOf("")
    var result by mutableStateOf("")
    var total by mutableStateOf("")

    private val decimalFormat = DecimalFormat("#.00")

    fun calculateInterest() {
        val p = principal.toDoubleOrNull() ?: return
        val r = rate.toDoubleOrNull() ?: return
        val t = time.toDoubleOrNull() ?: return

        // Simple Interest Formula: SI = (P * R * T) / 100
        val interest = (p * r * t) / 100
        val interestWithTotal = p+interest
        result = decimalFormat.format(interest)
        total = decimalFormat.format(interestWithTotal)
    }
}
