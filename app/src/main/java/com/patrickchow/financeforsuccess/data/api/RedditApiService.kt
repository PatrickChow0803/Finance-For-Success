package com.patrickchow.financeforsuccess.data.api

import retrofit2.http.GET
import retrofit2.http.Query

data class StockData(
    val no_of_comments: Int,
    val sentiment: String,
    val sentiment_score: Double,
    val ticker: String
)

interface RedditApiService {

    @GET("apps/reddit")
    suspend fun getTopStocks(@Query("date") date: String? = null): List<StockData>
}
