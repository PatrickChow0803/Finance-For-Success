package com.patrickchow.financeforsuccess.ui.screens.futurecalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.patrickchow.financeforsuccess.util.CustomRegex
import com.patrickchow.financeforsuccess.util.MathFormulas

class FutureValueViewModel : ViewModel() {

    private var _rate = mutableStateOf("")
    val rate: State<String> get() = _rate

    private var _nper = mutableStateOf("")
    val nper: State<String> get() = _nper

    private var _payment = mutableStateOf("")
    val payment: State<String> get() = _payment

    private var _presentValue = mutableStateOf("")
    val presentValue: State<String> get() = _presentValue

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

    fun onPresentValueChange(newPresentValue: String) {
        _presentValue.value = newPresentValue
    }

    fun onPaymentTypeChange(newType: Int) {
        _paymentType.value = newType
    }

    fun calculateFutureValue() {
        val r = _rate.value.toDoubleOrNull()?.div(100) ?: return
        val nper = _nper.value.toIntOrNull() ?: return
        val pmt = _payment.value.toDoubleOrNull() ?: return
        val pv = if (_presentValue.value.isEmpty()) 0.0 else _presentValue.value.toDoubleOrNull() ?: return
        val type = _paymentType.value

        val futureValue = MathFormulas.calculateFV(rate = r, nper = nper, pmt = pmt, pv = pv, type = type)
        _result.value = CustomRegex.decimalFormat.format(futureValue)
    }
}
