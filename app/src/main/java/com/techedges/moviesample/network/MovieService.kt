package com.techedges.moviesample.network

import com.techedges.moviesample.schema.Movie
import retrofit2.http.GET


/**
 * Created by Muhammad Naufal Azzaahid on 15/08/2020.
 */
interface MovieService {
    @GET("todos")
    suspend fun getMovie() : List<Movie>
}