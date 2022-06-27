package com.trei.testproject.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val retrofitService: RetrofitService
): BaseDataSource() {
    suspend fun getAllAlbums() = getResult { retrofitService.getAllAlbum() }
    suspend fun getImages(id: Int) = getResult { retrofitService.getImages(id) }
}