package com.patrickchow.financeforsuccess.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class InterestCalculatorViewModel : ViewModel() {
    var principal by mutableStateOf("")
    var rate by mutableStateOf("")
    var time by mutableStateOf("")
    var result by mutableStateOf("")
    var total by mutableStateOf("")

    fun calculateInterest() {
        val p = principal.toDoubleOrNull() ?: return
        val r = rate.toDoubleOrNull() ?: return
        val t = time.toDoubleOrNull() ?: return

        // Simple Interest Formula: SI = (P * R * T) / 100
        result = ((p * r * t) / 100).toString()
        total = ((1+(p * r * t)) / 100).toString()

    }
}
