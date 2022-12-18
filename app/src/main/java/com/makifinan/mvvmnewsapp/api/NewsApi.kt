package com.makifinan.mvvmnewsapp.api

import com.makifinan.mvvmnewsapp.model.NewsResponse
import com.makifinan.mvvmnewsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String="us",
        @Query("page")
        pageNumber:Int,
        @Query("apiKey")
        apiKey:String = Constants.API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber:Int,
        @Query("apiKey")
        apiKey:String = Constants.API_KEY
    ):Response<NewsResponse>


}