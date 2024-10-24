package com.patrickchow.financeforsuccess.data.repository

import com.patrickchow.financeforsuccess.data.api.RedditApiService
import com.patrickchow.financeforsuccess.ui.screens.reddit.RetrofitClient

class RedditRepository {

    private val apiService: RedditApiService = RetrofitClient.redditApiService

    suspend fun getTopStocks(date: String? = null) = apiService.getTopStocks(date)
}
