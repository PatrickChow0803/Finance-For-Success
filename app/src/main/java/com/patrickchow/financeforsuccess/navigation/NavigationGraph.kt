package com.patrickchow.financeforsuccess.navigation

import com.patrickchow.financeforsuccess.dataclass.getScreenTypeIndex
import com.patrickchow.financeforsuccess.dataclass.calculatorItems
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.patrickchow.financeforsuccess.ui.screens.*
import com.patrickchow.financeforsuccess.ui.screens.interestcalculator.InterestCalculatorScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable(ScreenType.InterestCalculator.name) { InterestCalculatorScreen(calculatorItems[getScreenTypeIndex(ScreenType.InterestCalculator)],navController)}
        composable(ScreenType.TipCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.TipCalculator)], navController) }
        composable(ScreenType.FutureCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.FutureCalculator)], navController) }
        composable(ScreenType.PresentCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.PresentCalculator)], navController) }
        composable(ScreenType.CurrencyConverter.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.CurrencyConverter)], navController) }
    }
}

