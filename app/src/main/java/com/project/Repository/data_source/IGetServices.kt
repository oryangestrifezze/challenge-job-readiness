package com.project.Repository.data_source

import com.project.Repository.model.CategoryIdResponse
import com.project.Repository.model.CategoryResponse
import com.project.Repository.model.DescriptionItemResponse
import com.project.Repository.model.HighlightsResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGetServices {

    @GET("sites/MLB/domain_discovery/search?limit=1")
    suspend fun fetchCategory(@Query("q") search : String) : List<CategoryResponse>

    @GET("highlights/MLB/category/{id}")
    suspend fun fetchHighlightsResponse(@Path("id") idCategory : String) : HighlightsResponse

    @GET("items")
    suspend fun fetchIdCategory(@Query("ids") items : String) : List<CategoryIdResponse>

    @GET("items/{id}/description")
    suspend fun fetchDescriptionItem(@Path("id") itemId: String) : DescriptionItemResponse
}