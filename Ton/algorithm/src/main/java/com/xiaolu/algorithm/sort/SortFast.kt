package com.xiaolu.algorithm.sort

/**
 * @Author: lollipop
 * @Time:2020/11/10
 * @Document: 快排
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
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