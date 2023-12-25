package com.compose.androidexpertc1.presentation.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import com.compose.androidexpertc1.core.domain.usecase.AddFavoriteMovieUseCase
import com.compose.androidexpertc1.core.domain.usecase.GetDetailMovieUseCase
import com.compose.androidexpertc1.core.domain.usecase.IsMovieFavoriteUseCase
import com.compose.androidexpertc1.core.domain.usecase.RemoveFavoriteMovieUseCase
import com.compose.androidexpertc1.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetDetailMovieUseCase,
    private val addFavoriteMovieUseCase: AddFavoriteMovieUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase,
    private val isMovieFavoriteUseCase: IsMovieFavoriteUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<MovieDetail?>>(
        UiState.Loading()
    )
    val state: StateFlow<UiState<MovieDetail?>> = _state.asStateFlow()


    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> get() = _isFavorite.asStateFlow()


    fun isMovieFavorite(movieId: Int) {
        viewModelScope.launch {
            isMovieFavoriteUseCase.invoke(movieId).collect { result ->
                _isFavorite.value = result
            }
        }
    }


    fun addFavoriteMovie(movie: MovieDetail) {
        viewModelScope.launch {
            addFavoriteMovieUseCase.invoke(movie)
            _isFavorite.value = !_isFavorite.value
        }
    }

    fun removeFavoriteMovie(movie: MovieDetail) {
        viewModelScope.launch {
            removeFavoriteMovieUseCase.invoke(movie)
            _isFavorite.value = !_isFavorite.value
        }
    }

    fun getDetailMovie(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailUseCase.invoke(movieId).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { UiState.Loading() }

                    is Resource.Error -> _state.update { UiState.Error(result.exception.message.toString()) }

                    is Resource.Success -> {
                        val movies = result.data
                        _state.update { UiState.Success(movies) }
                    }
                }
            }
        }
    }
}