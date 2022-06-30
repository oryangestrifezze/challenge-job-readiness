package com.project

import android.content.Context

class FavoriteItemsPreferences(context: Context) {

    val sharedKey = "SHERED_KEY_XML"
    val favorite_item_key = "FAVORITE_ITEM_KEY"

    private  val storage = context.getSharedPreferences(sharedKey, 0)

    fun saveFavoriteItem(id:Int) {
        storage.edit().putInt(favorite_item_key, id).apply()
    }

    fun getFavoriteItem() : Int {
        return storage.getInt(favorite_item_key, 0)
    }

    fun removeFavoriteItem() {
        //todo: implementar
    }
}