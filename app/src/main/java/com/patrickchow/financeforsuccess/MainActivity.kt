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
import com.patrickchow.financeforsuccess.ui.theme.FinanceForSuccessTheme
import com.patrickchow.financeforsuccess.ui.common.CalculatorCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceForSuccessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Finance For Success!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Define the type of calculator functions
        val calculatorFunctions: List<Pair<String, Int>> = listOf(
            Pair("Interest Calculator", R.drawable.interest),
            Pair("Tips Calculator", R.drawable.tips),
            Pair("Future Value Calculator", R.drawable.future_value),
            Pair("Present Value Calculator", R.drawable.present_value),
        )

        // Display calculator cards
        for (function in calculatorFunctions) {
            CalculatorCard(functionName = function.first, imageResId = function.second)
        }
    }
}
