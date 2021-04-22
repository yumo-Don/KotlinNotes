package com.lollipop.jetpack.room.daoEntity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
@Entity
data class Song(
    @PrimaryKey val songId: String,
    var songSheetIds: MutableList<String>,
    var songName: String
)