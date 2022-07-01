package com.project.Repository.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("category_id")
    val category_id: String?,
)
