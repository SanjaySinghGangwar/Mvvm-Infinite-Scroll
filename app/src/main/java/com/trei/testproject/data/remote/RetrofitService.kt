package com.trei.testproject.data.remote

import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.data.entities.ImageListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("albums")
    suspend fun getAllAlbum(): Response<List<AlbumModelItem>>

    @GET("photos")
    suspend fun getImages(@Query("albumId") albumId: Int): Response<List<ImageListItem>>

}