package com.lollipop.jetpack.room.daoEntity

import androidx.room.Embedded
import androidx.room.Relation
import com.lollipop.jetpack.room.daoEntity.SongSheet
import com.lollipop.jetpack.room.daoEntity.User

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document: 用户和歌单的联系实体
 */
data class UserAndSongSheet(
    @Embedded val user: User,
    @Relation(
        parentColumn = "uid",
        entityColumn = "createUserId"
    ) val songSheet: List<SongSheet>,
)