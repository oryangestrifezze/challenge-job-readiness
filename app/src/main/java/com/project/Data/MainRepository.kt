package com.project.Data

import android.util.Log
import com.project.Model.*


// Padrão para lidar com dados (api/db)
class MainRepository {
    private val service: IGetServices = RetrofitServices.createGetService()

    suspend fun getCategory(search: String): List<ItemModel> {

        var list: List<String>?
        var listResult: List<ItemModel> = emptyList()

        try {
            service.fetchCategory(search)[0].let {
                list = getHighlights(it.category_id.toString())
                    .content?.filter { it.type == "ITEM" }?.map { it.id }
                listResult = getCategoryId(list).map { it.body }
            }
        } catch (e: Exception) {
            Log.e("MainRepository", "getCategory() : ${e.toString()}")
        }
        return listResult

    }

    suspend fun getFavoritesItems(list: List<String>?): List<ItemModel> {
        var listResult: List<ItemModel> = emptyList()
        try {
            listResult = getCategoryId(list).map { it.body }
        } catch (e: Exception) {
            Log.e("MainRepository", "getFavoritesItems() : ${e.toString()}")
        }
        return listResult
    }


    private suspend fun getHighlights(idCategory: String): HighlightsResponse {
        return service.fetchHighlightsResponse(idCategory)
    }

    suspend fun getCategoryId(items: List<String>?): List<CategoryId> {
        return service.fetchIdCategory(items?.joinToString()!!)
    }

}