package com.patrickchow.financeforsuccess.data.api

import com.patrickchow.financeforsuccess.dataclass.RedditStock
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApiService {
    @GET("apps/reddit")
    suspend fun getRedditStocks(
        @Query("date") date: String? = null // Optional date parameter
    ): List<RedditStock>
}
