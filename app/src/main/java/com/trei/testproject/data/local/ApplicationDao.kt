package com.trei.testproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.data.entities.ImageListItem


@Dao
interface ApplicationDao {
    @Query("SELECT * FROM albums_List")
    fun getAllAlbums(): LiveData<List<AlbumModelItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(albums: List<AlbumModelItem>)

    @Query("SELECT * FROM image_list WHERE albumId = :id")
    fun getImages(id: Int): LiveData<List<ImageListItem>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(imageListItem: List<ImageListItem>)

}