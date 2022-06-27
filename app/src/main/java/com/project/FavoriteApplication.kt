package com.project

import android.app.Application

class FavoriteApplication : Application() {
    companion object {
        lateinit var favoritePreferences : FavoriteItemsPreferences
    }

    override fun onCreate() {
        super.onCreate()
        favoritePreferences = FavoriteItemsPreferences(applicationContext)
    }
}