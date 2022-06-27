package com.trei.testproject.data.repository


import com.trei.testproject.data.local.ApplicationDao
import com.trei.testproject.data.remote.RemoteDataSource
import com.trei.testproject.utils.performGetOperation
import javax.inject.Inject

class mRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ApplicationDao
) {
    fun getAllAlbums() = performGetOperation(
        databaseQuery = { localDataSource.getAllAlbums() },
        networkCall = { remoteDataSource.getAllAlbums() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    fun getImages(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getImages(id) },
        networkCall = { remoteDataSource.getImages(id) },
        saveCallResult = { localDataSource.insert(it) }
    )
}