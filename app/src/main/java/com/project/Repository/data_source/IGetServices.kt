package com.project.Repository.data_source

import com.project.Repository.model.CategoryId
import com.project.Repository.model.CategoryResponse
import com.project.Repository.model.HighlightsResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGetServices {

    @GET("sites/MLB/domain_discovery/search?limit=1") //Preditor
    suspend fun fetchCategory(@Query("q") search : String) : List<CategoryResponse>

    @GET("highlights/MLB/category/{id}") // esse precisa
    suspend fun fetchHighlightsResponse(@Path("id") idCategory : String) : HighlightsResponse

    @GET("items")
    suspend fun fetchIdCategory(@Query("ids") items : String) : List<CategoryId>
}