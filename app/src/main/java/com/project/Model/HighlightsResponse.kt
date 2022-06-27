package com.project.Model

import com.google.gson.annotations.SerializedName

data class HighlightsResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("type")
    val type: String?,
)
