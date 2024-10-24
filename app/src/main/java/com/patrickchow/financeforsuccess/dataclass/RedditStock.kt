package com.patrickchow.financeforsuccess.dataclass

data class RedditStock(
    val no_of_comments: Int,
    val sentiment: String,
    val sentiment_score: Double,
    val ticker: String
)
