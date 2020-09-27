package com.lollipop.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lollipop.kotlinnotes.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    lateinit var layout: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(layout.root)
    }
}