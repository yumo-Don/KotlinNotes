package com.xiaolu.algorithm.sort

/**
 * @Author: lollipop
 * @Time:2020/11/10
 * @Document: 快排
 */
class SortFast {
    companion object {

        var data = arrayOf(2, 7, 4, 6, 8, 5, 4, 1,6)

        @JvmStatic
        fun main(args: Array<String>) {
            sort(data, 0, data.size - 1)
            println(data.contentToString())
        }

        private fun sort(data: Array<Int>, start: Int, end: Int) {
            if (start >= end) return

            val partition = findPartition(data, start, end)
            sort(data, start, partition - 1)
            sort(data, partition + 1, end)
        }

        private fun findPartition(data: Array<Int>, start: Int, end: Int): Int {
            val pivot = data[end]
            var index = start
            for (i in start until end) {
                if (data[i] < pivot) {
                    val copyValue = data[i]
                    data[i] = data[index]
                    data[index] = copyValue
                    index++
                }
            }
            data[end] = data[index]
            data[index] = pivot
            return index
        }
    }
}