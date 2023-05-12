package com.vik.contentlisting.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vik.contentlisting.data.util.FileUtils
import com.vik.contentlisting.domain.model.Content


@SuppressLint("ResourceType")
@Composable
fun MovieItem(movie: Content) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable(onClick = { /* Navigate to the movie detail screen */ })
    ) {
        Image(
            painter = painterResource(id = getImage(context, movie.poster_image)),
            contentDescription = "Movie Poster",
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
        )
        Text(text = movie.name, style = MaterialTheme.typography.subtitle1)
    }
}

fun getImage(context: Context, posterImage: String): Int {
    val imageId = FileUtils.getExistingDrawable(posterImage, context)
   return if(imageId == 0) {
        com.vik.contentlisting.R.drawable.poster1
    } else imageId
}
