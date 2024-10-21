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
import com.patrickchow.financeforsuccess.dataClass.CalculatorItem
import com.patrickchow.financeforsuccess.dataClass.calculatorItems
import com.patrickchow.financeforsuccess.navigation.ScreenType
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

        // Display calculator cards
        for (item in calculatorItems) {
            CalculatorCard(functionName = item.title, imageResId = item.icon)
        }
    }
}
