package com.lollipop.application

import android.app.Application
import com.lollipop.jetpack.room.*
import com.lollipop.jetpack.room.dao.SongDao
import com.lollipop.jetpack.room.dao.SongSheetDao
import com.lollipop.jetpack.room.dao.UserAndSongSheetDao
import com.lollipop.jetpack.room.dao.UserDao
import com.lollipop.jetpack.room.daoEntity.Address
import com.lollipop.jetpack.room.daoEntity.Song
import com.lollipop.jetpack.room.daoEntity.SongSheet
import com.lollipop.jetpack.room.daoEntity.User
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
class LollipopApplication : Application() {

    lateinit var userDao: UserDao
    lateinit var songDao: SongDao
    lateinit var songSheetDao: SongSheetDao
    lateinit var userAndSongSheetDao: UserAndSongSheetDao

    override fun onCreate() {
        super.onCreate()
        initRoom()
    }

    private fun initRoom() {
        MusicDatabase.getInstance(this).apply {
            userDao = userDao()
            songDao = songDao()
            songSheetDao = songSheetDao()
        }

//        insertData()
    }

    private fun insertData() {
        val address = Address("北京", "东王庄小区")
        val userOne = User("17611703977_lollipop", "唐鸿程", "男", "17611703977", address, "小鹿")
        val address2 = Address("杭州", "雨山区")
        val userTwo = User("17611702977_ym", "ym", "女", "17611702977", address2, "阿里")


        val songList = mutableListOf<Song>().apply {
            add(Song("song_1", mutableListOf("sheetId_1", "sheetId_2"), "Star Sky"))
            add(Song("song_2", mutableListOf("sheetId_1"), "Daytime"))
            add(Song("song_3", mutableListOf("sheetId_1"), "PLANET"))
        }

        val songSheet = SongSheet("sheetId_1", "17611703977_lollipop", "纯音乐", songList)


        Executors.newSingleThreadExecutor().execute {
            userDao.insertUserList(listOf(userOne, userTwo))
            songDao.insertSongs(songList)
            songSheetDao.insertSongSheet(songSheet)
        }
    }
}