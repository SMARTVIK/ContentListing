package com.vik.contentlisting.domain.model

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("page")
    val page: PageX
)