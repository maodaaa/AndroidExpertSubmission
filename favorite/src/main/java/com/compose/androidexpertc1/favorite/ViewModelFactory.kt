package com.compose.androidexpertc1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.compose.androidexpertc1.core.domain.usecase.GetFavoriteMoviesUseCase
import com.compose.androidexpertc1.favorite.presentation.FavoriteViewModel
import javax.inject.Inject


class ViewModelFactory @Inject constructor(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(getFavoriteMoviesUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}