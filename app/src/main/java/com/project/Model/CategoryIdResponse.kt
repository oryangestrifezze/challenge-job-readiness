package com.project.Model

import com.google.gson.annotations.SerializedName

data class CategoryIdResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("amount")
    val amount: String?,

    @SerializedName("thumbnail")
    val thumbnail: String?
)
