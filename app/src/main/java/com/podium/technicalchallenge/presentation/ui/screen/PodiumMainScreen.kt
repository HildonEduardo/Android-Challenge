package com.podium.technicalchallenge.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.podium.technicalchallenge.ui.Screen

@Preview(showBackground = true)
@Composable
fun PodiumMainScreenPreview() {
    PodiumMainScreen()
}

@Composable
fun PodiumMainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.TopMovies,
        Screen.BrowseByGenre,
        Screen.BrowseByAll
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.Black,
                contentColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    val isSelected = currentRoute == screen.route
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                screen.icon, contentDescription = null,
                                tint = if (isSelected) {
                                    LocalContentColor.current
                                } else {
                                    Color.White
                                }
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                style = TextStyle(color = if (isSelected) LocalContentColor.current else Color.White)
                            )
                        },
                        selected = isSelected,
                        selectedContentColor = MaterialTheme.colors.primary,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.TopMovies.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.TopMovies.route) { TopMoviesScreen(navController) }
            composable(Screen.BrowseByGenre.route) { BrowseByGenreScreen(navController) }
            composable(Screen.BrowseByAll.route) { BrowseAllScreen(navController) }
//            composable(Screen.MovieDetail.route) { MovieDetailScreen(navController) }
        }
    }
}
