package com.xiaolu.algorithm.sort

import java.util.*

/**
 * @Author: lollipop
 * @Time:2020/11/9
 * @Document: 冒泡排序
 * 操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
 */
class SortBubble {

    companion object {
        private val data = arrayOf(2, 6, 4, 9, 0, 8, 7, 9)
        private val data2 = arrayOf(2, 6, 4, 9, 0, 8, 7, 9)

        @JvmStatic
        fun main(args: Array<String>) {
            sortAsc(data)
            sortDesc(data2)
        }

        private fun sortAsc(data: Array<Int>) {
            for (index in data.indices) {
                var flag = false
                for (j in 0 until data.size - index - 1) {
                    if (data[j] > data[j + 1]) {
                        val copyValue = data[j]
                        data[j] = data[j + 1]
                        data[j + 1] = copyValue
                        flag = true
                    }
                }
                if (!flag) break
            }

            println(data.contentToString())
        }

        private fun sortDesc(data: Array<Int>) {
            for (index in data.indices) {
                var flag = false
                for (j in 0 until data.size - index - 1) {
                    if (data[j] < data[j + 1]) {
                        val copyValue = data[j]
                        data[j] = data[j + 1]
                        data[j + 1] = copyValue
                        flag = true
                    }
                }
                if (!flag) break
            }
            println(data.contentToString())
        }

    }
}