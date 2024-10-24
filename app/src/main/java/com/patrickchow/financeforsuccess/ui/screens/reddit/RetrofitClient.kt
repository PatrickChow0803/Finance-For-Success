package com.patrickchow.financeforsuccess.ui.screens.reddit

import com.patrickchow.financeforsuccess.data.api.RedditApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://tradestie.com/api/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val redditApiService: RedditApiService = retrofit.create(RedditApiService::class.java)
}
