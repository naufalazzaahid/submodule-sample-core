package com.techedges.moviesample.di

import com.techedges.moviesample.DummySampleParent
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent


/**
 * Created by Muhammad Naufal Azzaahid on 13/09/2020.
 */

// Types scoped to this component must be annotated with @LoggedUserScope
@MyCustomScope
// Make UserComponent subcomponent of ApplicationComponent
@DefineComponent(parent = ActivityComponent::class)
interface MyCustomComponent {

    // Builder to create instances of UserComponent
    @DefineComponent.Builder
    interface Builder {
        fun setDummyParent(@BindsInstance dummySampleParent: DummySampleParent): Builder
        fun build(): MyCustomComponent
    }
}