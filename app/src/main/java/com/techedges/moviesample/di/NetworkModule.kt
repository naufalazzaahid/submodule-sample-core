package com.techedges.moviesample.di

import com.techedges.moviesample.network.MovieService
import com.techedges.moviesample.network.MovieServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


/**
 * Created by Muhammad Naufal Azzaahid on 15/08/2020.
 */
@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {
    @Provides
    fun provideMovieService() : MovieService {
        return MovieServiceFactory.createMovieService()
    }
}