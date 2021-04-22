package com.lollipop.jetpack.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lollipop.jetpack.room.daoEntity.Song
import com.lollipop.jetpack.room.daoEntity.SongSheet

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
@Dao
interface SongSheetDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongSheet(songSheet: SongSheet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongSheetList(songSheet: List<SongSheet>)

    @Query("SELECT * FROM SongSheet WHERE createUserId = :uid")
    fun getSongSheetByUid(uid: String):SongSheet
}