package com.trei.testproject.di

import android.content.Context

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.trei.testproject.data.local.AppDatabase
import com.trei.testproject.data.local.ApplicationDao
import com.trei.testproject.data.remote.RemoteDataSource
import com.trei.testproject.data.remote.RetrofitService
import com.trei.testproject.data.repository.mRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(
            OkHttpClient.Builder()
                .connectTimeout(180L, TimeUnit.SECONDS)
                .writeTimeout(180L, TimeUnit.SECONDS)
                .readTimeout(180L, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        )
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(retrofitService: RetrofitService) = RemoteDataSource(retrofitService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideApplicationDao(db: AppDatabase) = db.mApplicationDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource,
                          localDataSource: ApplicationDao
    ) = mRepository(remoteDataSource, localDataSource)
}