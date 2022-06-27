package com.project.Model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("domain_name")
    val domain_name: String?,

    @SerializedName("category_id")
    val category_id: String?,
)
