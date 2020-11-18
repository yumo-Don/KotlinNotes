package com.lollipop.kotlinnotes

import android.content.Context
import android.widget.TextView
import java.lang.reflect.Array.get
import java.lang.reflect.Array.set

/**
 * @Author: lollipop
 * @Time:2020/10/9
 * @Document:
 */
class ApplyAndAlso {
    val text: String = ""
    private var text1: String = ""
    fun test(context: Context) {

        TextView(context).apply {
            textSize = 14f
            text = ".."
            text1 = "1"
        }

        try {
            TextView(context).also {
                try {
                    it.textSize = 14f
                } catch (e: Exception) {
                }
            }
        } catch (e: Exception) {
        }

        var string: String? = null

        string?.let {
            it.length
            it.substring(0)
        }

        with(string) {
            this?.length
            this?.get(0)
        }

        string?.length

        kotlin.run { this }

        run {

        }
    }
}



