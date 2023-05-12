package com.vik.contentlisting.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vik.contentlisting.domain.model.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor (private val movieRepository: MovieRepository) : ViewModel() {

    private val _movies = MutableStateFlow<List<Content>>(emptyList())
    val movies: StateFlow<List<Content>> = _movies

    private var currentPage = 1

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading

    init {
        loadMovies()
    }

    fun loadMoreMovies() {
        if (!_loading.value) {
            currentPage++
            loadMovies()
        }
    }

    private fun loadMovies() {
        _loading.value = true
        viewModelScope.launch {
            val movies = movieRepository.loadMovies(currentPage, PAGE_SIZE)
            _movies.value = _movies.value + movies
            _loading.value = false
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}
