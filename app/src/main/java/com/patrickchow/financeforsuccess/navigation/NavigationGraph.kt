package com.patrickchow.financeforsuccess.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.patrickchow.financeforsuccess.ui.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenType.InterestCalculator.name) {
        composable(ScreenType.InterestCalculator.name) { WIP(ScreenType.InterestCalculator) }
        composable(ScreenType.TipCalculator.name) { WIP(ScreenType.InterestCalculator) }
        composable(ScreenType.FutureCalculator.name) { WIP(ScreenType.InterestCalculator) }
        composable(ScreenType.PresentCalculator.name) { WIP(ScreenType.InterestCalculator) }
        composable(ScreenType.CurrencyConverter.name) { WIP(ScreenType.InterestCalculator) }
    }
}
