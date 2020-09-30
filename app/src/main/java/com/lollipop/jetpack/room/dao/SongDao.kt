package com.lollipop.jetpack.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lollipop.jetpack.room.daoEntity.Song

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(songs: List<Song>)

}