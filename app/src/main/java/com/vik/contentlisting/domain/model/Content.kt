package com.vik.contentlisting.domain.model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("name")
    val name: String,
    @SerializedName("poster-image")
    val poster_image: String
)