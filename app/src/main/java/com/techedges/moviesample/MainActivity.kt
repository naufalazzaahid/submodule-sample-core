package com.techedges.moviesample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.techedges.libmodule.ModuleClass
import com.techedges.moviesample.di.SubcomponentManager
import com.techedges.moviesample.network.MovieService
import com.techedges.moviesample.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var service: MovieService

    @Inject
    lateinit var dummySample: DummySample

    @Inject
    lateinit var dummySampleParent: DummySampleParent

    @Inject
    lateinit var subcomponentManager: SubcomponentManager

    private val viewModel: MovieViewModel by viewModels()

    private val channel = BroadcastChannel<Int>(10)

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCounter.setOnClickListener {
            counter++
            channel.offer(counter)
        }

        viewModel.processIntent(channel)

        lifecycleScope.launch {
            viewModel
                .getStates()
                .collect{
                Log.v("qqwe1231", "$it state (${Thread.currentThread().name})")
            }
        }

        val testClassModule = ModuleClass("dari modul")

        Log.v("testsubmodul", testClassModule.nameSample)
    }
}