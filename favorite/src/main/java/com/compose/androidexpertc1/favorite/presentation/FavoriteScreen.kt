package com.compose.androidexpertc1.favorite.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.presentation.common.UiState
import com.compose.androidexpertc1.presentation.components.EmptyContent
import com.compose.androidexpertc1.presentation.components.ErrorContent
import com.compose.androidexpertc1.presentation.components.LoadingContent

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel
) {
    val state by viewModel.state.collectAsState()

    DisposableEffect(Unit) {
        viewModel.getFavoriteMovies()
        onDispose { }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary,
        topBar = {
            FavoriteTopBar()
        },
        content = { padding ->
            when (val result = state) {
                is UiState.Loading<List<Movie>?> -> LoadingContent()
                is UiState.Error -> ErrorContent(
                    result.message
                )

                is UiState.Success -> {
                    val movies = result.data
                    if (movies.isNullOrEmpty()) {
                        EmptyContent()
                    } else {
                        FavoriteContent(
                            movies,
                            modifier = Modifier.padding(padding),

                            )
                    }
                }
            }
        }
    )
}