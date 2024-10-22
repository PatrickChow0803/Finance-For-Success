package com.patrickchow.financeforsuccess.ui.screens.presentcalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.patrickchow.financeforsuccess.util.CustomRegex
import com.patrickchow.financeforsuccess.util.MathFormulas

class PresentValueViewModel : ViewModel() {

    private var _rate = mutableStateOf("")
    val rate: State<String> get() = _rate

    private var _nper = mutableStateOf("")
    val nper: State<String> get() = _nper

    private var _payment = mutableStateOf("")
    val payment: State<String> get() = _payment

    private var _futureValue = mutableStateOf("")
    val futureValue: State<String> get() = _futureValue

    // Assume zero to symbolize the end period
    private var _paymentType = mutableStateOf(0)
    val paymentType: State<Int> get() = _paymentType

    private var _result = mutableStateOf("")
    val result: State<String> get() = _result

    fun onRateChange(newRate: String) {
        _rate.value = newRate
    }

    fun onTimeChange(newTime: String) {
        _nper.value = newTime
    }

    fun onPaymentChange(newPayment: String) {
        _payment.value = newPayment
    }

    fun onFutureValueChange(newFutureValue: String) {
        _futureValue.value = newFutureValue
    }

    fun onPaymentTypeChange(newType: Int) {
        _paymentType.value = newType
    }

    fun calculatePresentValue() {
        val r = _rate.value.toDoubleOrNull()?.div(100) ?: return // Convert percentage to decimal
        val nper = _nper.value.toIntOrNull() ?: return
        val pmt = _payment.value.toDoubleOrNull() ?: return
        val fv = if (_futureValue.value.isEmpty()) 0.0 else _futureValue.value.toDoubleOrNull() ?: return
        val type = _paymentType.value

        val presentValue = MathFormulas.calculatePV(rate = r, nper = nper, pmt = pmt, fv = fv, type = type)
        _result.value = CustomRegex.decimalFormat.format(presentValue)
    }
}
