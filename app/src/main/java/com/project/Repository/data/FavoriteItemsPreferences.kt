package com.project.Repository.data

import android.content.Context

class FavoriteItemsPreferences(context: Context) {

    private val sharedKey = "SHERED_KEY_XML"
    private val favorite_id_key = "FAVORITE_ID_KEY"
    private val idListFavorites = mutableListOf<String>()
    private  val storage = context.getSharedPreferences(sharedKey, 0)


    fun saveFavoriteItem(id: String) {
        storage.edit().putString("$favorite_id_key $id", id).apply()
        idListFavorites.add(id)
    }

    fun getFavoritesItems() = idListFavorites

    fun removeFavoriteItem(id : String) {
        idListFavorites.remove(id)
    }
}