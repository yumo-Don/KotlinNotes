package com.lollipop.jetpack.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.lollipop.jetpack.room.daoEntity.UserAndSongSheet

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */

@Dao
interface UserAndSongSheetDao {

    @Transaction
    @Query("SELECT * FROM UserTable WHERE uid = :uid")
    fun getSongSheetFromUser(uid: String):List<UserAndSongSheet>
}