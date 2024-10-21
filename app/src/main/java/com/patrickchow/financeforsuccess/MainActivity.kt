package com.patrickchow.financeforsuccess


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.patrickchow.financeforsuccess.dataClass.CalculatorItem
import com.patrickchow.financeforsuccess.dataClass.calculatorItems
import com.patrickchow.financeforsuccess.navigation.NavigationGraph
import com.patrickchow.financeforsuccess.navigation.ScreenType
import com.patrickchow.financeforsuccess.ui.theme.FinanceForSuccessTheme
import com.patrickchow.financeforsuccess.ui.common.CalculatorCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceForSuccessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
