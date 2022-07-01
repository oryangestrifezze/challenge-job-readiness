package com.project.Repository.data

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