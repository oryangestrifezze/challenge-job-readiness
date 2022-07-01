package com.project.Repository.model

import com.google.gson.annotations.SerializedName

data class HighlightsResponse(
    @SerializedName("content")
    val content: List<highlightItemModel>?,

    )
