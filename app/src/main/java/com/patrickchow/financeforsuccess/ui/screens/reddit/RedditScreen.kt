package com.patrickchow.financeforsuccess.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.dataclass.CalculatorItem
import com.patrickchow.financeforsuccess.ui.common.AppScaffold
import com.patrickchow.financeforsuccess.ui.screens.reddit.StockItem
import com.patrickchow.financeforsuccess.viewmodel.RedditViewModel
@Composable
fun RedditScreen(calculatorItem: CalculatorItem, navController: NavController) {
    val viewModel: RedditViewModel = viewModel()
    val stockList by viewModel.stockList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    AppScaffold(
        title = calculatorItem.title,
        navController = navController,
        useScrollableColumn = false,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(stockList) { stock ->
                    StockItem(stock)
                }
            }

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    CircularProgressIndicator()
                }
            } else if (errorMessage != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    // TODO: Make string resource
                    Text(
                        text = errorMessage ?: "Unknown error, please try again later",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchTopStocks()
    }
}
