package com.patrickchow.financeforsuccess.ui.screens.interestcalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import androidx.compose.runtime.State

class InterestCalculatorViewModel : ViewModel() {

    private var _principal = mutableStateOf("")
    val principal: State<String> get() = _principal

    private var _rate = mutableStateOf("")
    val rate: State<String> get() = _rate

    private var _time = mutableStateOf("")
    val time: State<String> get() = _time

    private var _result = mutableStateOf("")
    val result: State<String> get() = _result

    private var _total = mutableStateOf("")
    val total: State<String> get() = _total

    private val decimalFormat = DecimalFormat("#.00")

    fun onPrincipalChange(newPrincipal: String) {
        _principal.value = newPrincipal
    }

    fun onRateChange(newRate: String) {
        _rate.value = newRate
    }

    fun onTimeChange(newTime: String) {
        _time.value = newTime
    }

    fun calculateInterest() {
        val p = _principal.value.toDoubleOrNull() ?: return
        val r = _rate.value.toDoubleOrNull() ?: return
        val t = _time.value.toDoubleOrNull() ?: return

        // Simple Interest Formula: SI = (P * R * T) / 100
        val interest = (p * r * t) / 100
        val totalAmount = p + interest
        _result.value = decimalFormat.format(interest)
        _total.value = decimalFormat.format(totalAmount)
    }

    fun calculateCompoundInterest(numberOfCompoundPerYear: Int) {
        val p = _principal.value.toDoubleOrNull() ?: return
        val r = _rate.value.toDoubleOrNull()?.div(100) ?: return // Convert percentage to decimal
        val t = _time.value.toDoubleOrNull() ?: return

        // Compound Interest Formula: A = P (1 + r/n)^(nt)
        val amount = p * Math.pow((1 + r / numberOfCompoundPerYear), (numberOfCompoundPerYear * t))
        val interest = amount - p

        _result.value = decimalFormat.format(interest)
        _total.value = decimalFormat.format(amount)
    }
}
