package com.patrickchow.financeforsuccess.dataClass

import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.navigation.ScreenType

data class CalculatorItem(
    val title: String,
    val icon: Int,
    val screen: ScreenType
)

val calculatorItems = listOf(
    CalculatorItem(
        title = "Interest Calculator",
        icon = R.drawable.interest,
        screen = ScreenType.InterestCalculator
    ),
    CalculatorItem(
        title = "Tips Calculator",
        icon = R.drawable.tips,
        screen = ScreenType.TipCalculator
    ),
    CalculatorItem(
        title = "Future Value Calculator",
        icon = R.drawable.future_value,
        screen = ScreenType.FutureCalculator
    ),
    CalculatorItem(
        title = "Present Value Calculator",
        icon = R.drawable.present_value,
        screen = ScreenType.PresentCalculator
    ),
    CalculatorItem(
        title = "Currency Exchange",
        icon = R.drawable.exchange,
        screen = ScreenType.CurrencyConverter
    ),
)