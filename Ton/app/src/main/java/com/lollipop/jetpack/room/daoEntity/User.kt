package com.lollipop.jetpack.room.daoEntity

import androidx.room.*

/**
 * @Author: lollipop
 * @Time:2020/9/23
 * @Document:
 */
@Entity(tableName = "UserTable")
data class User(
    @PrimaryKey var uid: String,
    var name: String,
    var sex: String,
    @ColumnInfo(name = "phoneNumber") var phone: String? = null,
    @Embedded var address: Address? = null,
    @Ignore var company: String? = null,
) {
    constructor() : this("", "", "", "", null, "")
}

