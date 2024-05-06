package com.podium.technicalchallenge.data.network

object Queries {
    fun getMoviesQuery(limit : Int = 5) =
"""
    query GetTopMoviesQuery {
      movies(sort : DESC, orderBy : \"voteAverage\", limit : $limit) {
        title
        overview
        posterPath
        voteAverage
        releaseDate
      }
    }
"""
    fun getAllGenres() =
        """
    query GetAllGenres {
        genres
       }
"""
}
