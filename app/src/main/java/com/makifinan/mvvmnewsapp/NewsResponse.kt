package com.makifinan.mvvmnewsapp

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)