package com.vik.contentlisting.domain.model

import com.google.gson.annotations.SerializedName

data class ContentItems(
    @SerializedName("content")
    val content: List<Content>
)