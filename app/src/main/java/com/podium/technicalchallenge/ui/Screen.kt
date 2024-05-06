package com.podium.technicalchallenge.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object TopMovies : Screen("top_movies", "Top 5", Icons.Default.Star)
    object BrowseByGenre : Screen("browse_by_genre", "Genres", Icons.AutoMirrored.Filled.List)
    object BrowseByAll : Screen("browse_by_all", "All", Icons.AutoMirrored.Filled.List)
    object MovieDetail : Screen("movie_detail", "Movie Detail", Icons.Default.Info)
}