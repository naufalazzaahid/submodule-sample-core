package com.techedges.moviesample.di

import com.techedges.moviesample.DummySampleChild
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn


/**
 * Created by Muhammad Naufal Azzaahid on 13/09/2020.
 */
@InstallIn(MyCustomComponent::class)
@EntryPoint
interface MyCustomComponentEntryPoint {
    fun dummySampleChild(): DummySampleChild
}