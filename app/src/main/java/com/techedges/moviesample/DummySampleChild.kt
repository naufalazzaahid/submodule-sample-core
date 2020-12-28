package com.techedges.moviesample

import com.techedges.moviesample.di.MyCustomScope
import javax.inject.Inject


/**
 * Created by Muhammad Naufal Azzaahid on 13/09/2020.
 */
@MyCustomScope
class DummySampleChild @Inject constructor(val dummySample: DummySampleParent)