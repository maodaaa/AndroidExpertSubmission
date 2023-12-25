package com.compose.androidexpertc1.core.di

import com.compose.androidexpertc1.core.domain.usecase.GetFavoriteMoviesUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun getFavoriteMoviesUseCase(): GetFavoriteMoviesUseCase
}