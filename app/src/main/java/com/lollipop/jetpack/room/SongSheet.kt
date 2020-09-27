package com.lollipop.jetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
@Entity
data class SongSheet(
    @PrimaryKey val songSheetId: String,
    val createUserId: String,
    var name: String,
    var songList: MutableList<String>
)