package com.compose.androidexpertc1.presentation.screen.home


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.compose.androidexpertc1.presentation.common.UiState
import com.compose.androidexpertc1.presentation.components.EmptyContent
import com.compose.androidexpertc1.presentation.components.ErrorContent
import com.compose.androidexpertc1.presentation.components.LoadingContent


@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary,
        topBar = { HomeTopBar() },
        content = { padding ->
            when (val result = state) {
                is UiState.Loading -> LoadingContent()
                is UiState.Error -> ErrorContent(
                    result.message
                )

                is UiState.Success -> {
                    val movies = result.data
                    if (movies.isNullOrEmpty()) {
                        EmptyContent()
                    } else {
                        HomeContent(
                            movies,
                            modifier = Modifier.padding(padding),
                            navController
                        )
                    }
                }
            }
        }
    )
}