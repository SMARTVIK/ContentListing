package com.vik.contentlisting.presentation

import com.vik.contentlisting.domain.model.Content

interface MovieRepository {
    suspend fun loadMovies(page: Int, pageSize: Int): List<Content>
}
