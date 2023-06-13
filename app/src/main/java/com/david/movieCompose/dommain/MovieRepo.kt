package com.david.movieCompose.dommain

import com.david.network.IMovieService
import javax.inject.Inject
import com.david.network.dto.MovieItem as MovieItemNetwork

class MovieRepo @Inject constructor() {

    private val movieService = IMovieService.create()

    suspend fun getMovieList(): List<MovieItem> {
        val response = movieService.getPopular()
        val results = response?.results
        return convertMovieList(results)
    }

    private fun convertMovieList(results: List<MovieItemNetwork>?): List<MovieItem> {
        return results?.map { movie ->
            MovieItem(
                backdrop_path = movie.backdrop_path,
                id = movie.id,
                original_language = movie.original_language,
                original_title = movie.original_title,
                overview = movie.overview,
                poster_path = movie.poster_path,
                release_date = movie.release_date,
                title = movie.title,
                video = movie.video
            )
        } ?: emptyList()
    }
}