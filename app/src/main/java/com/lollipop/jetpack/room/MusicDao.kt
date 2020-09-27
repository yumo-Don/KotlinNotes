package com.lollipop.jetpack.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @Author: lollipop
 * @Time:2020/9/23
 * @Document:
 */
@Dao
interface MusicDao {
    @Query("SELECT * FROM UserTable Where uid = :uid")
    fun findByUid(uid: String): User

    @Insert
    fun insertUser(user: User)
}