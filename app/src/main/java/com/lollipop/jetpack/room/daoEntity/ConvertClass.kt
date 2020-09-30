package com.lollipop.jetpack.room.daoEntity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.typeOf

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
class ConvertClass {

    val gson = Gson()

    @TypeConverter
    fun songListToString(song: List<Song>?) =
        song?.let {
            gson.toJson(song)
        }

    @TypeConverter
    fun stringToSongList(string: String): List<Song> {
        return gson.fromJson(string, object : TypeToken<List<Song>>() {}.type)
    }


    @TypeConverter
    fun songSheetIdsToString(sheetIds: List<String>?) =
        sheetIds?.let {
            gson.toJson(sheetIds)
        }

    @TypeConverter
    fun stringToSongSheetIds(sheetIds: String): List<String> {
        return gson.fromJson(sheetIds, object : TypeToken<List<String>>() {}.type)
    }
}