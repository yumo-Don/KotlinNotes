package com.lollipop.jetpack.room

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lollipop.kotlinnotes.LOG_TAG
import com.lollipop.kotlinnotes.databinding.ActivityRoomBinding
import java.util.concurrent.Executors

class RoomActivity : AppCompatActivity() {

    lateinit var layout: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(layout.root)
        getDataFromBase()
    }


    private fun getDataFromBase() {
        val userAndSongSheetDao = MusicDatabase.getInstance(this).userAndSongSheetDao()
        val songSheetDao = MusicDatabase.getInstance(this).songSheetDao()
        val songDao = MusicDatabase.getInstance(this).songDao()

        Executors.newSingleThreadExecutor().execute {
            val songSheetFromUser = userAndSongSheetDao.getSongSheetFromUser("17611703977_lollipop")
            Log.d(LOG_TAG, songSheetFromUser[0].toString())

            val songSheet = songSheetDao.getSongSheetByUid("17611703977_lollipop")
            Log.d(LOG_TAG, songSheet.toString())

        }


    }
}