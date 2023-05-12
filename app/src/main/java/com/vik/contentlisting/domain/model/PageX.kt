package com.vik.contentlisting.domain.model

import com.google.gson.annotations.SerializedName

data class PageX(
    @SerializedName("content-items")
    val content_items: ContentItems,
    @SerializedName("page-num")
    val page_num: String,
    @SerializedName("page-size")
    val page_size: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("total-content-items")
    val total_content_items: String
)