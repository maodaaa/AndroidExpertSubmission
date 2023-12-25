package com.compose.androidexpertc1.presentation.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.compose.androidexpertc1.presentation.common.UiState
import com.compose.androidexpertc1.presentation.components.EmptyContent
import com.compose.androidexpertc1.presentation.components.ErrorContent
import com.compose.androidexpertc1.presentation.components.LoadingContent

@Composable
fun DetailScreen(
    movieId: Int?,
    viewModel: DetailViewModel,
    navController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

    LaunchedEffect(movieId) {
        movieId?.let {
            viewModel.getDetailMovie(it)
            viewModel.isMovieFavorite(it)
        }
    }

    when (val result = state) {
        is UiState.Loading -> LoadingContent()
        is UiState.Error -> ErrorContent(
            errorMessage = result.message
        )

        is UiState.Success -> {
            val moviesDetail = result.data
            if (moviesDetail == null) {
                EmptyContent()
            } else {
                DetailScreenContent(
                    isFavorite = isFavorite,
                    movieDetail = moviesDetail,
                    onAddClick = { viewModel.addFavoriteMovie(moviesDetail) },
                    onRemoveClick = { viewModel.removeFavoriteMovie(moviesDetail) },
                    navController
                )
            }
        }
    }
}