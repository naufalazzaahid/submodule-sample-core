package com.techedges.moviesample

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


/**
 * Created by Muhammad Naufal Azzaahid on 15/08/2020.
 */

@ActivityScoped
class DummySample @Inject constructor () {
    val myName: String = "wow success"
}