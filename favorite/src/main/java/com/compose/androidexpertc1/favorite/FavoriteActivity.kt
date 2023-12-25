package com.compose.androidexpertc1.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.compose.androidexpertc1.core.di.FavoriteModuleDependencies
import com.compose.androidexpertc1.favorite.di.DaggerFavoriteComponents
import com.compose.androidexpertc1.favorite.presentation.FavoriteScreen
import com.compose.androidexpertc1.favorite.presentation.FavoriteViewModel
import com.compose.androidexpertc1.favorite.ui.theme.AndroidExpertC1Theme
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponents.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExpertC1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoriteScreen(favoriteViewModel)
                }
            }
        }
    }
}