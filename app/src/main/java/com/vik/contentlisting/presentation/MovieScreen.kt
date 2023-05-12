package com.vik.contentlisting.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieScreen(movieViewModel: MovieViewModel) {
    val movies by movieViewModel.movies.collectAsState()
    val filteredList by movieViewModel.movies.collectAsState()
    val loading by remember(movieViewModel) { movieViewModel.loading }.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        SearchBar() {query->
                if(query.isNotEmpty()) {
                    movies.filter { it.name.contains(query) }
                }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            itemsIndexed(movies) { index, movie ->
                if (index == movies.size - 1 && !loading) {
                    movieViewModel.loadMoreMovies()
                }
                MovieItem(movie = movie)
            }

        }
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
