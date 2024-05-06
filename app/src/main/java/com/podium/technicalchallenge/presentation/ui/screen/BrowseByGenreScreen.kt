package com.podium.technicalchallenge.presentation.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.podium.technicalchallenge.R
import com.podium.technicalchallenge.presentation.ui.component.GenreItem
import com.podium.technicalchallenge.ui.Screen

@Composable
fun BrowseByGenreScreen(navController: NavController) {
    val genres = getGenres() // Assuming you have a function to get the list of genres
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.browse_by_genre_title),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(genres) { genre ->
                GenreItem(genre = genre, onClick = {
                    navController.navigate("${Screen.BrowseByGenre.route}/${genre}")
                })
            }
        }
    }
}

data class Genre(val name: String)

// Placeholder function to get genres
fun getGenres(): List<Genre> {
    return listOf(
        Genre("Action"),
        Genre("Comedy"),
        Genre("Drama"),
        Genre("Sci-Fi"),
        Genre("Thriller")
    )
}
