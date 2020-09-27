package com.lollipop.jetpack.room

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
    var songSheet: MutableList<String>,
    var songName: String
)