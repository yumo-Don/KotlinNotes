package com.lollipop.jetpack.room.daoEntity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @Author: lollipop
 * @Time:2020/9/28
 * @Document:
 */
class SongAndSongSheet(
    @Embedded val song: Song,
    @Relation(
        parentColumn = "songId",
        entityColumn = "",
    ) val songSheets: List<SongSheet>
)