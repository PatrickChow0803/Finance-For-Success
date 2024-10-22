package com.patrickchow.financeforsuccess.ui.screens.presentvalue

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.patrickchow.financeforsuccess.util.CustomRegex
import com.patrickchow.financeforsuccess.util.MathFormulas

class PresentValueViewModel : ViewModel() {

    private var _futureValue = mutableStateOf("")
    val futureValue: State<String> get() = _futureValue

    private var _rate = mutableStateOf("")
    val rate: State<String> get() = _rate

    private var _time = mutableStateOf("")
    val time: State<String> get() = _time

    private var _result = mutableStateOf("")
    val result: State<String> get() = _result

    fun onFutureValueChange(newFutureValue: String) {
        _futureValue.value = newFutureValue
    }

    fun onRateChange(newRate: String) {
        _rate.value = newRate
    }

    fun onTimeChange(newTime: String) {
        _time.value = newTime
    }

    fun calculatePresentValue() {
        val fv = _futureValue.value.toDoubleOrNull() ?: return
        val r = _rate.value.toDoubleOrNull()?.div(100) ?: return // Convert percentage to decimal
        val t = _time.value.toDoubleOrNull() ?: return

        val presentValue = MathFormulas.calculatePresentValue(fv, r, t)
        _result.value = CustomRegex.decimalFormat.format(presentValue)
    }
}
