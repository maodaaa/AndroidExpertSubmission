package com.compose.androidexpertc1.core.data.resource

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: Exception) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
}