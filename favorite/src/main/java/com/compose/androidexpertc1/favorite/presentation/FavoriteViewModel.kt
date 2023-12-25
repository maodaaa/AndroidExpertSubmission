package com.compose.androidexpertc1.favorite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.core.domain.usecase.GetFavoriteMoviesUseCase
import com.compose.androidexpertc1.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<UiState<List<Movie>?>>(
            UiState.Loading()
        )
    val state: StateFlow<UiState<List<Movie>?>> =
        _state.asStateFlow()

    init {
        getFavoriteMovies()
    }

    fun getFavoriteMovies() {
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().collect { result ->
                when (result) {
                    is Resource.Error -> _state.update {
                        UiState.Error(
                            result.exception.message.toString()
                        )
                    }

                    is Resource.Success -> {
                        val movies = result.data
                        _state.update {
                            UiState.Success(
                                movies
                            )
                        }
                    }

                    is Resource.Loading -> _state.update { UiState.Loading() }
                }
            }
        }
    }
}