package com.patrickchow.financeforsuccess.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.patrickchow.financeforsuccess.dataClass.calculatorItems
import com.patrickchow.financeforsuccess.dataClass.getScreenTypeIndex
import com.patrickchow.financeforsuccess.ui.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable(ScreenType.InterestCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.InterestCalculator)], navController) }
        composable(ScreenType.TipCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.TipCalculator)], navController) }
        composable(ScreenType.FutureCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.FutureCalculator)], navController) }
        composable(ScreenType.PresentCalculator.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.PresentCalculator)], navController) }
        composable(ScreenType.CurrencyConverter.name) { WIP(calculatorItems[getScreenTypeIndex(ScreenType.CurrencyConverter)], navController) }
    }
}

