package com.patrickchow.financeforsuccess.ui.screens.reddit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.data.api.StockData

@Composable
fun StockItem(stock: StockData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Space between text and image
        ) {
            Column(modifier = Modifier.weight(1f)) { // Use weight to allow column to fill available space
                // TODO: Make string resources
                Text(
                    text = "Ticker: ${stock.ticker}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Comments: ${stock.no_of_comments}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Sentiment: ${stock.sentiment ?: "Undecided"}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Score: ${stock.sentiment_score}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Image(
                painter = painterResource(id = getSentimentImage(stock.sentiment)),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

// TODO: Make this more secure than just hard string check
// Function to determine the image resource based on sentiment
private fun getSentimentImage(sentiment: String?): Int {
    return when (sentiment) {
        "Bullish" -> R.drawable.bullish
        "Bearish" -> R.drawable.bearish
        else -> R.drawable.scale // For null or other values
    }
}
