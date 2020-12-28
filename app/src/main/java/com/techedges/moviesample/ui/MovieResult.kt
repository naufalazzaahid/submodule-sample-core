package com.techedges.moviesample.ui

import com.techedges.moviesample.schema.Movie


/**
 * Created by Muhammad Naufal Azzaahid on 16/08/2020.
 */
sealed class MovieResult {
    sealed class GetMovieResult : MovieResult() {
        data class Success(val movieList: List<Movie>)
        object loading
        data class Error(val throwable: Error)
    }
}