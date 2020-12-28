package com.techedges.moviesample.di

import com.techedges.moviesample.DummySampleParent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


/**
 * Created by Muhammad Naufal Azzaahid on 13/09/2020.
 */

@ActivityScoped
class SubcomponentManager @Inject constructor(
    // Since UserManager will be in charge of managing the UserComponent's
    // lifecycle, it needs to know how to create instances of it. We use the
    // provider (i.e. factory) Dagger generates for us to create instances of UserComponent.
    private val userComponentProvider: Provider<MyCustomComponent.Builder>,
    private val dummySampleParent: DummySampleParent
) {

    /**
     *  UserComponent is specific to a logged in user. Holds an instance of
     *  UserComponent. This determines if the user is logged in or not, when the
     *  user logs in, a new Component will be created.
     *  When the user logs out, this will be null.
     */
    var userComponent: MyCustomComponent? = null
        private set

    private fun userLoggedIn() {
        userComponent = userComponentProvider.get().setDummyParent(dummySampleParent).build()
    }

    private fun logout() {
        // When the user logs out, we remove the instance of UserComponent from memory
        userComponent = null
    }
}