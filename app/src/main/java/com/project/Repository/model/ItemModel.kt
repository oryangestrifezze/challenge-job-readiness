package com.project.Repository.model

data class ItemModel(
    val id: String,
    val title: String?,
    val price: String,
    val secure_thumbnail: String?,
    val available_quantity: String?,
    var isFavorite: Boolean,
    var description: String?,
    )
