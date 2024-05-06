package com.podium.technicalchallenge.data.network.responses

import com.podium.technicalchallenge.data.model.Movie

/**
 * Created by hildon.lima<hildon.eduardo@gmail.com> on 05/05/24.
 */
data class TopMoviesResponse(
    val data: Data
)

data class Data(
    val movies: List<Movie>
)

