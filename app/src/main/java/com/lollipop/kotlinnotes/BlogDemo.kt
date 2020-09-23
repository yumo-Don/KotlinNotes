package com.lollipop.kotlinnotes

import android.content.Context
import android.util.Log
import android.widget.TextView

/**
 * @Author: lollipop
 * @Document:
 */


class BlogDemo {


    companion object {
        private val list = listOf(1, 2, 3)

        @JvmStatic
        fun main(args: Array<String>) {
            list.asSequence().map {
                println("map :$it")
                it * 2
            }.find { it > 2 }


            val b = B()
        }
    }


}

class B {
    fun z(title: String, name: String, age: String,sex:String) {

    }
}














