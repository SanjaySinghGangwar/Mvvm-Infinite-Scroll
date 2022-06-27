package com.trei.testproject.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_list")
data class ImageListItem(
    val albumId: Int,
    @NonNull
    @PrimaryKey
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)