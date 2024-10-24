package com.patrickchow.financeforsuccess.navigation

import com.patrickchow.financeforsuccess.dataclass.getScreenTypeIndex
import com.patrickchow.financeforsuccess.dataclass.calculatorItems
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.patrickchow.financeforsuccess.ui.RedditScreen
import com.patrickchow.financeforsuccess.ui.screens.*
import com.patrickchow.financeforsuccess.ui.screens.futurecalculator.FutureValueScreen
import com.patrickchow.financeforsuccess.ui.screens.interestcalculator.InterestCalculatorScreen
import com.patrickchow.financeforsuccess.ui.screens.presentcalculator.PresentValueScreen
import com.patrickchow.financeforsuccess.ui.screens.tipscalculator.TipsCalculatorScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable(ScreenType.InterestCalculator.name) {
            InterestCalculatorScreen(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.InterestCalculator
                )],
                navController,
            )
        }
        composable(ScreenType.TipCalculator.name) {
            TipsCalculatorScreen(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.TipCalculator
                )],
                navController,
            )
        }
        composable(ScreenType.FutureCalculator.name) {
            FutureValueScreen(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.FutureCalculator
                )],
                navController,
            )
        }
        composable(ScreenType.PresentCalculator.name) {
            PresentValueScreen(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.PresentCalculator
                )],
                navController,
            )
        }
        composable(ScreenType.WSB.name) {
            RedditScreen(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.WSB
                )],
                navController,
            )
        }
        composable(ScreenType.CurrencyConverter.name) {
            WIP(
                calculatorItems[getScreenTypeIndex(
                    ScreenType.CurrencyConverter
                )],
                navController,
            )
        }
    }
}

