package com.makifinan.mvvmnewsapp.model

import com.makifinan.mvvmnewsapp.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)