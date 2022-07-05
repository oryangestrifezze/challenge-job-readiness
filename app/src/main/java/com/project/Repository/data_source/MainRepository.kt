package com.project.Repository.data_source

import android.util.Log
import com.project.Repository.model.CategoryIdResponse
import com.project.Repository.model.DescriptionItemResponse
import com.project.Repository.model.HighlightsResponse
import com.project.Repository.model.ItemModel


class MainRepository {

    private val service: IGetServices = RetrofitServices.createGetService()

    suspend fun getCategory(search: String): List<ItemModel> {
        var list: List<String>?
        var response: List<ItemModel> = emptyList()
        try {
            service.fetchCategory(search)[0]
                .let { it ->
                    list = getHighlights(it.category_id.toString()).content
                        ?.filter { it.type == "ITEM" }
                        ?.map { it.id }
                    response = getCategoryId(list).map { it.body }
                }
        } catch (e: Exception) {
            Log.e("MainRepository", "getCategory() : $e")
        }
        return response

    }

    suspend fun getFavoritesItems(list: List<String>?): List<ItemModel> {
        var response: List<ItemModel> = emptyList()
        try {
            response = getCategoryId(list).map { it.body }
        } catch (e: Exception) {
            Log.e("MainRepository", "getFavoritesItems() : $e")
        }
        return response
    }

    private suspend fun getHighlights(idCategory: String): HighlightsResponse {
        var response: HighlightsResponse = HighlightsResponse(null)
        try {
            response = service.fetchHighlightsResponse(idCategory)
        } catch (e: Exception) {
            Log.e("MainRepository", "getHighlights() : $e")
        }
        return response
    }

    private suspend fun getCategoryId(items: List<String>?): List<CategoryIdResponse> {
        var response: List<CategoryIdResponse> = emptyList()
        try {
            response = service.fetchIdCategory(items?.joinToString()!!)
        } catch (e: Exception) {
            Log.e("MainRepository", "getCategoryId() : $e")
        }
        return response
    }

    suspend fun getDescriptionItem(id: String): DescriptionItemResponse {
        var response = DescriptionItemResponse(null)
        try {
            response = service.fetchDescriptionItem(id)
        } catch (e: Exception) {
            Log.e("MainRepository", "getDescriptionItem: $e")
        }
        return response
    }
}