package com.project.Data

import com.project.Model.CategoryIdResponse
import com.project.Model.CategoryResponse
import com.project.Model.HighlightsResponse
import retrofit2.http.GET

interface IGetServices {

    @GET("sites/MLB/domain_discovery/search?limit=1&q=Game")
    suspend fun fetchCategory() : List<CategoryResponse>

    @GET("https://api.mercadolibre.com/highlights/MLB/category/MLB1144")
    suspend fun fetchIdCategory() : List<CategoryIdResponse>

    @GET("https://api.mercadolibre.com/sites/MLB/search?category=MLB1094")
    suspend fun fetchHighlightsResponse() : List<HighlightsResponse>
}