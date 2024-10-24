package com.patrickchow.financeforsuccess.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.patrickchow.financeforsuccess.data.api.StockData
import com.patrickchow.financeforsuccess.viewmodel.RedditViewModel

@Composable
fun RedditScreen() {
    val viewModel: RedditViewModel = viewModel()
    val stockList by viewModel.stockList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTopStocks()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(stockList) { stock ->
                    StockItem(stock)
                }
            }
        }
    }
}

@Composable
fun StockItem(stock: StockData) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = "Ticker: ${stock.ticker}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Comments: ${stock.no_of_comments}")
        Text(text = "Sentiment: ${stock.sentiment}")
        Text(text = "Score: ${stock.sentiment_score}")
    }
}
