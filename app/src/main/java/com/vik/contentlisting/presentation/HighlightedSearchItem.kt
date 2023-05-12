package com.vik.contentlisting.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HighlightedSearchItem(query: String, itemText: String) {
    val annotatedString = buildAnnotatedString {
        val lowercaseItemText = itemText.lowercase()
        val lowercaseQuery = query.lowercase()
        var startIndex = 0
        var lastIndex = lowercaseItemText.indexOf(lowercaseQuery)

        while (lastIndex >= 0) {
            append(itemText.substring(startIndex, lastIndex))
            withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                append(itemText.substring(lastIndex, lastIndex + query.length))
            }
            startIndex = lastIndex + query.length
            lastIndex = lowercaseItemText.indexOf(lowercaseQuery, startIndex)
        }

        append(itemText.substring(startIndex))
    }

    Text(text = annotatedString)
}
