package com.patrickchow.financeforsuccess.ui.screens.reddit

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.patrickchow.financeforsuccess.dataclass.RedditStock
import com.patrickchow.financeforsuccess.ui.viewmodel.RedditStockViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StockScreen(viewModel: RedditStockViewModel = hiltViewModel()) {
    val stocks by viewModel.redditStocks.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getStocks()  // Initial API call without date
    }

    if (loading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(stocks) { stock ->
                StockItem(stock)
            }
        }
    }
}

@Composable
fun StockItem(stock: RedditStock) {
    Text("${stock.ticker} - ${stock.sentiment} (${stock.no_of_comments} comments)")
}