package com.compose.androidexpertc1.presentation.screen.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
) {
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start
            )
        },
        actions = {
            IconButton(onClick = {
                val deepLinkUri = Uri.parse("favorite://com.compose.androidexpertc1")
                val intent = Intent(Intent.ACTION_VIEW, deepLinkUri)
                context.startActivity(intent)
            })
            {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favourite Icon",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    )
}
