package com.project.Model

import com.google.gson.annotations.SerializedName

data class HighlightsResponse(
    @SerializedName("content")
    val content: List<highlightItem>?,

)
