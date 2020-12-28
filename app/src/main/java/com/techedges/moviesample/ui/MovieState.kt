package com.techedges.moviesample.ui

import com.techedges.moviesample.schema.Movie


/**
 * Created by Muhammad Naufal Azzaahid on 16/08/2020.
 */

data class MovieState(val isLoading: Boolean, val movieList: List<Movie>){
    companion object {
        fun idle() : MovieState {
            return MovieState(isLoading = false, movieList = emptyList())
        }
    }
}