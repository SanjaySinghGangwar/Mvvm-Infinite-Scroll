package com.trei.testproject.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums_list")
data class AlbumModelItem(
    @NonNull
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)