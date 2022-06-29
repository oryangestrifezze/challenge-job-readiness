package com.project.Data

import android.util.Log
import com.project.Data.RetrofitServices
import com.project.Model.*


// Padrão para lidar com dados (api/db)
class MainRepository {
    private val service : IGetServices = RetrofitServices.createGetService()

    suspend fun getCategory(search: String) : List<ItemModel> {

        var list: List<String>? = emptyList()
        var listResult: List<ItemModel> = emptyList()

        try {
           service.fetchCategory(search)[0].let {
                list = getHighlights(it.category_id.toString()).content?.filter { it.type == "ITEM" }?.map { it.id }
                listResult = getCategoryId(list?.joinToString()!!).map { it.body }
            }
        } catch (e :Exception) {
            Log.e("MainRepository", "getCategory() : ${e.toString()}")
        }
        return  listResult

    }

    suspend fun getHighlights(idCategory: String) : HighlightsResponse {
        return service.fetchHighlightsResponse(idCategory)
    }

    suspend fun getCategoryId(items: String) : List<CategoryId> {
        return service.fetchIdCategory(items)
    }
}