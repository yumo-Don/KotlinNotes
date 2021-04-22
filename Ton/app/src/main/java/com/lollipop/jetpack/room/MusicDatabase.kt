package com.lollipop.jetpack.room

import android.content.Context
import androidx.room.*
import com.lollipop.jetpack.room.dao.SongDao
import com.lollipop.jetpack.room.dao.SongSheetDao
import com.lollipop.jetpack.room.dao.UserAndSongSheetDao
import com.lollipop.jetpack.room.dao.UserDao
import com.lollipop.jetpack.room.daoEntity.ConvertClass
import com.lollipop.jetpack.room.daoEntity.Song
import com.lollipop.jetpack.room.daoEntity.SongSheet
import com.lollipop.jetpack.room.daoEntity.User
import com.lollipop.kotlinnotes.DATABASE_NAME

/**
 * @Author: lollipop
 * @Time:2020/9/23
 * @Document:
 */
@Database(entities = [Song::class, SongSheet::class, User::class], version = 1)
@TypeConverters(ConvertClass::class)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun songDao(): SongDao
    abstract fun songSheetDao(): SongSheetDao
    abstract fun userAndSongSheetDao(): UserAndSongSheetDao

    companion object {
        @Volatile
        private var instance: MusicDatabase? = null

        fun getInstance(context: Context): MusicDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MusicDatabase::class.java,
                DATABASE_NAME
            ).build()

    }
}