package com.techedges.moviesample.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Muhammad Naufal Azzaahid on 15/08/2020.
 */
object MovieServiceFactory {
    fun createMovieService(): MovieService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()))
            .build()

        return retrofit.create(MovieService::class.java)
    }
}