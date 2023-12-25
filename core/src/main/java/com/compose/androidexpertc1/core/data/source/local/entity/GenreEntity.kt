package com.compose.androidexpertc1.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class GenreEntity(
    @ColumnInfo(name = "id") val id: Int,

    @ColumnInfo(name = "name") val name: String,
)
