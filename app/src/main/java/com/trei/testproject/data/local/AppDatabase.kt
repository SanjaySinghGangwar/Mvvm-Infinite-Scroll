package com.trei.testproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.data.entities.ImageListItem

@Database(entities = [AlbumModelItem::class,ImageListItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mApplicationDao(): ApplicationDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "albumsList")
                .fallbackToDestructiveMigration()
                .build()
    }

}