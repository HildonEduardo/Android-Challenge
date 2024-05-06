package com.podium.technicalchallenge.presentation.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.podium.technicalchallenge.ui.Screen
import com.podium.technicalchallenge.R

@Composable
fun TopMoviesScreen(navController: NavController) {
    val topMovies = getTopMovies() // Assuming you have a function to get the top movies
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.top_movies_title),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(topMovies) { movie ->
                TopMovieItem(movie = movie, onClick = {
                    navController.navigate(Screen.MovieDetail.route)
                })
            }
        }
    }
}

@Composable
fun TopMovieItem(movie: Movie, onClick: () -> Unit) {
    ListItem(
        modifier = Modifier.clickable(onClick = onClick),
        leadingContent = {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        headlineContent = { Text(text = movie.title) },
        trailingContent = { Text(text = movie.rating.toString()) }
    )
}

data class Movie(val title: String, val rating: Float)

// Placeholder function to get top movies
fun getTopMovies(): List<Movie> {
    return listOf(
        Movie("Movie 1", 4.5f),
        Movie("Movie 2", 4.3f),
        Movie("Movie 3", 4.2f),
        Movie("Movie 4", 4.0f),
        Movie("Movie 5", 3.9f)
    )
}