package com.lollipop.jetpack.room

import androidx.room.*

/**
 * @Author: lollipop
 * @Time:2020/9/23
 * @Document:
 */
@Entity(tableName = "UserTable")
data class User(
    @PrimaryKey val uid: String,
    val name: String,
    val sex: String,
    @ColumnInfo(name = "phoneNumber") var phone: String? = null,
    @Embedded val address: Address,
    @Ignore var company: String? = null,
)

