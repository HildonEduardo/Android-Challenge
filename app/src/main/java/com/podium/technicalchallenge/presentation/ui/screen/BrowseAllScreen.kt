package com.podium.technicalchallenge.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.podium.technicalchallenge.R
import com.podium.technicalchallenge.data.model.Movie
import com.podium.technicalchallenge.presentation.ui.component.MovieItem
import com.podium.technicalchallenge.ui.Screen

@Composable
fun BrowseAllScreen(navController: NavController) {
    val topMovies = getTopMovies() // Assuming you have a function to get the top movies
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.browse_all_title),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(topMovies) { movie ->
                MovieItem(movie = movie, onClick = {
                    navController.navigate(Screen.MovieDetail.route)
                })
            }
        }
    }
}

@Preview
@Composable
fun BrowseAllScreenPreview() {
    BrowseAllScreen(navController = rememberNavController())
}

// Placeholder function to get top movies
fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "2020-04-12",
            "Mortal Kombat Legends: Scorpion's Revenge",
            8.4
        ),
        Movie(
            "Soul",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
            "2020-12-25",
            "Soul",
            8.3
        ),
        Movie(
            "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg",
            "2019-04-24",
            "Avengers: Endgame",
            8.3
        ),
        Movie(
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "2018-04-25",
            "Avengers: Infinity War",
            8.3
        ),
        Movie(
            "A 17 year old finds out that his girlfriend is dying, so he sets out to give her an entire life, in the last year she has left.",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/xNcjlHPRNoqbpaYis0Y3zX4Hq0x.jpg",
            "2020-11-27",
            "Life in a Year",
            8.3
        )
    )
}