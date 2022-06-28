package com.project.Data

import com.project.Data.RetrofitServices
import com.project.Model.CategoryId
import com.project.Model.CategoryIdResponse
import com.project.Model.CategoryResponse
import com.project.Model.HighlightsResponse


// Padrão para lidar com dados (api/db)
class MainRepository {
    private val service : IGetServices = RetrofitServices.createGetService()

    suspend fun getCategory(search: String) : List<CategoryResponse> {
        return service.fetchCategory(search)
    }

    suspend fun getHighlights(idCategory: String) : HighlightsResponse {
        return service.fetchHighlightsResponse(idCategory)
    }

    suspend fun getCategoryId(items: String) : List<CategoryId> {
        return service.fetchIdCategory(items)
    }
}