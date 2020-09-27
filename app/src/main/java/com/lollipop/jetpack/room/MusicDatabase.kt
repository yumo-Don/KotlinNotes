package com.lollipop.jetpack.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @Author: lollipop
 * @Time:2020/9/23
 * @Document:
 */
@Database(entities = [User::class], version = 1)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}