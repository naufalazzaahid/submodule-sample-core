package com.techedges.moviesample.ui

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.*

/**
 * Created by Muhammad Naufal Azzaahid on 16/08/2020.
 */
@FlowPreview
@ExperimentalCoroutinesApi
class MovieViewModel @ViewModelInject constructor(@Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val mutableStateFlow: MutableStateFlow<String> = MutableStateFlow("Initial")

    private lateinit var channel : BroadcastChannel<Int>

    fun processIntent(channel: BroadcastChannel<Int>) {
        this.channel = channel

        viewModelScope.launch {
            channel
                .asFlow()
                .flatMapMerge {
                    flow {
                        Log.v("qqwe1231", "$it send (${Thread.currentThread().name})")
                        if(it % 2 == 0){
                            delay(1000)
                        } else {
                            delay(2000)
                        }
                        emit("$it Going")
                    }
                }
                .flowOn(Dispatchers.IO)
                .collect {
                Log.v("qqwe1231", "$it channel (${Thread.currentThread().name})")
                mutableStateFlow.value = it
            }
        }
    }

    fun getStates() : StateFlow<String> {
        return mutableStateFlow
    }
}