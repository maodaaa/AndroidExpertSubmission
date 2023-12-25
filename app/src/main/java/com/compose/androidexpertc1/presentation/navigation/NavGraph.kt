package com.compose.androidexpertc1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.androidexpertc1.presentation.screen.detail.DetailScreen
import com.compose.androidexpertc1.presentation.screen.detail.DetailViewModel
import com.compose.androidexpertc1.presentation.screen.home.HomeScreen
import com.compose.androidexpertc1.presentation.utils.Constant.MOVIE_DETAIL_KEY


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetail.route,
            arguments = listOf(
                navArgument(MOVIE_DETAIL_KEY) {
                    type = NavType.IntType
                },
            )
        ) { backStackEntry ->

            val movieId =
                backStackEntry.arguments?.getInt(MOVIE_DETAIL_KEY)
            val viewModel: DetailViewModel = hiltViewModel()
            DetailScreen(movieId, viewModel, navController)
        }


    }
}

