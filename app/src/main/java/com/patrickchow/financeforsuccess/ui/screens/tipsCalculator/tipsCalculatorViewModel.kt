package com.patrickchow.financeforsuccess.ui.screens.tipsCalculator

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class TipsCalculatorViewModel : ViewModel() {
    private var _billAmount = mutableStateOf("")
    val billAmount: State<String> get() = _billAmount

    private var _tipPercentage = mutableStateOf("")
    val tipPercentage: State<String> get() = _tipPercentage

    private var _calculatedTip = mutableStateOf("")
    val calculatedTip: State<String> get() = _calculatedTip

    private var _totalAmount = mutableStateOf("")
    val totalAmount: State<String> get() = _totalAmount

    fun onBillAmountChange(newBillAmount: String) {
        _billAmount.value = newBillAmount
    }

    fun onTipPercentageChange(newTipPercentage: String) {
        _tipPercentage.value = newTipPercentage
    }

    fun calculateTip() {
        val bill = billAmount.value.toDoubleOrNull() ?: 0.0
        val tipPercent = tipPercentage.value.toDoubleOrNull() ?: 0.0
        val tip = bill * (tipPercent / 100)
        val total = bill + tip

        _calculatedTip.value = String.format("%.2f", tip)
        _totalAmount.value = String.format("%.2f", total)
    }
}
