package com.vik.contentlisting.presentation

import android.content.Context
import com.vik.contentlisting.data.util.FileUtils
import com.vik.contentlisting.domain.model.Content
import javax.inject.Inject

class MovieRepoImpl @Inject constructor (
    private val context: Context
    ) : MovieRepository {
    override suspend fun loadMovies(page: Int, pageSize: Int): List<Content> {
        return when(page){
            1 -> FileUtils.parseJson(context, "CONTENTLISTINGPAGE-PAGE1.json").content_items.content
            2 -> FileUtils.parseJson(context, "CONTENTLISTINGPAGE-PAGE2.json").content_items.content
            3 -> FileUtils.parseJson(context, "CONTENTLISTINGPAGE-PAGE3.json").content_items.content
            else -> {
                emptyList<Content>()
            }
        }
    }
}