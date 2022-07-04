package com.project.Repository.data

import android.content.Context

class FavoriteItemsPreferences(context: Context) {

    private val sharedKey = "FAVORITE_KEY"
    private  val storage = context.getSharedPreferences(sharedKey, 0)


    fun saveFavoriteItem(id: String) {
        val items = getFavoritesItems()
        items.add(id)
        storage.edit().putStringSet(sharedKey, items).apply()
    }

    fun getFavoritesItems()  = storage.getStringSet(sharedKey, mutableSetOf())!!.toMutableSet()

    fun removeFavoriteItem(id : String) {
        val items = getFavoritesItems()
        println("lista antes de remover: $items")
        items.remove(id)
        println("lista depois de remover: $items")

        storage.edit().putStringSet(sharedKey, items).apply()

        println("lista final de getFavorite: ${getFavoritesItems()}")

    }
}