package com.project.Data

import com.project.Data.RetrofitServices
import com.project.Model.CategoryIdResponse
import com.project.Model.CategoryResponse
import com.project.Model.HighlightsResponse

// Padrão para lidar com dados (api/db)
class MainRepository {
    private val service : IGetServices = RetrofitServices.createGetService()

    suspend fun getCategory() : CategoryResponse {
        return service.fetchCategory()
    }

    suspend fun getCategoryId() : List<CategoryIdResponse> {
        return service.fetchIdCategory()
    }

    suspend fun getHighlights() : List<HighlightsResponse> {
        return service.fetchHighlightsResponse()
    }
}