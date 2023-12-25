package com.compose.androidexpertc1.favorite.di

import android.content.Context
import com.compose.androidexpertc1.core.di.FavoriteModuleDependencies
import com.compose.androidexpertc1.favorite.FavoriteActivity
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponents {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponents
    }

}