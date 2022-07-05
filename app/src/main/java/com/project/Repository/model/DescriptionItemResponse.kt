package com.project.Repository.model

import com.google.gson.annotations.SerializedName

data class DescriptionItemResponse(
    @SerializedName("plain_text")
    val plain_text: String?
)
