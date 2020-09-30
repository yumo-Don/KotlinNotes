package com.lollipop.jetpack.room.dao

import androidx.room.*
import com.lollipop.jetpack.room.daoEntity.User

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM UserTable Where uid = :uid")
    fun findUserByUid(uid: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun delete(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserList(user: List<User>)
}