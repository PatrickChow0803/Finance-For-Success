package com.patrickchow.financeforsuccess.data.repository

import com.patrickchow.financeforsuccess.data.api.RedditApiService
import com.patrickchow.financeforsuccess.dataclass.RedditStock
import javax.inject.Inject

class RedditStockRepository @Inject constructor(private val apiService: RedditApiService) {

    suspend fun getRedditStocks(date: String? = null): List<RedditStock> {
        return apiService.getRedditStocks(date)
    }
}
