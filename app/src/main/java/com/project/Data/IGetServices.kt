package com.project.Data

import com.project.Model.CategoryIdResponse
import com.project.Model.CategoryResponse
import com.project.Model.HighlightsResponse
import retrofit2.http.GET

interface IGetServices {

    @GET("sites/MLB/domain_discovery/search?limit=1&q=Game")
    suspend fun fetchCategory() : List<CategoryResponse>

    @GET("sites/MLB/search?category=MLB1094")
    suspend fun fetchHighlightsResponse() : List<HighlightsResponse>

    @GET("items?ids=MLB1482764536,MLB1482764536#options")
    suspend fun fetchIdCategory() : List<CategoryIdResponse>
}