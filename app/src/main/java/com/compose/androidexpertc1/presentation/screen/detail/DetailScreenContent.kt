package com.compose.androidexpertc1.presentation.screen.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.compose.androidexpertc1.core.domain.model.MovieDetail

@Composable
fun DetailScreenContent(
    isFavorite: Boolean,
    movieDetail: MovieDetail,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    navController: NavHostController,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary,
        topBar = {
            DetailTopBar(
                navController = navController,
                isFavorite = isFavorite,
                onRemoveClick = onRemoveClick,
                onAddClick = onAddClick,
            )
        }
    ) { padding ->
        DetailContent(
            movieDetail,
            modifier = Modifier.padding(padding),
        )
    }
}