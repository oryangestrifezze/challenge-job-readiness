package com.project.Model

import com.google.gson.annotations.SerializedName

data class Product (
    val title: String
)
data class CategoryId (
    @SerializedName("body")
    val body: Product
)