//package com.patrickchow.financeforsuccess.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.patrickchow.financeforsuccess.ui.common.CalculatorList
//import com.patrickchow.financeforsuccess.ui.screens.WIP
//
//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "calculator_list") {
//        composable("calculator_list") {
//            // Your list screen
//            composable("calculator_list") { CalculatorList(navController) }
//            composable("wip_screen") { WIP(ScreenType.TipCalculator) }
//        }
//        composable(ScreenType.InterestCalculator.name) { WIP(ScreenType.InterestCalculator) }
//        composable(ScreenType.TipCalculator.name) { WIP(ScreenType.TipCalculator) }
//        composable(ScreenType.FutureCalculator.name) { WIP(ScreenType.FutureCalculator) }
//        composable(ScreenType.PresentCalculator.name) { WIP(ScreenType.PresentCalculator) }
//        composable(ScreenType.CurrencyConverter.name) { WIP(ScreenType.CurrencyConverter) }
//    }
//}
