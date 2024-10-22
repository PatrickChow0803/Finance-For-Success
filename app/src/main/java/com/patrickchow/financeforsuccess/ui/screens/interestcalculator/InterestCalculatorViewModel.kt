package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class InterestCalculatorViewModel : ViewModel() {

    private var _principal by mutableStateOf("")
    val principal: String get() = _principal

    private var _rate by mutableStateOf("")
    val rate: String get() = _rate

    private var _time by mutableStateOf("")
    val time: String get() = _time

    private var _result by mutableStateOf("")
    val result: String get() = _result

    private var _total by mutableStateOf("")
    val total: String get() = _total

    private val decimalFormat = DecimalFormat("#.00")

    fun calculateInterest() {
        // Use the values directly, since they are String types
        val p = _principal.toDoubleOrNull() ?: return
        val r = _rate.toDoubleOrNull() ?: return
        val t = _time.toDoubleOrNull() ?: return

        // Simple Interest Formula: SI = (P * R * T) / 100
        val interest = (p * r * t) / 100
        val totalAmount = p + interest // Renamed for clarity
        _result = decimalFormat.format(interest)
        _total = decimalFormat.format(totalAmount)
    }

    fun onPrincipalChange(newPrincipal: String) {
        _principal = newPrincipal
    }

    fun onRateChange(newRate: String) {
        _rate = newRate
    }

    fun onTimeChange(newTime: String) {
        _time = newTime
    }
}
