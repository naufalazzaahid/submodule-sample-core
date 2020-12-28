package com.techedges.moviesample.ui


/**
 * Created by Muhammad Naufal Azzaahid on 16/08/2020.
 */

sealed class MovieIntent () {
    object GetMovieIntent : MovieIntent()
}