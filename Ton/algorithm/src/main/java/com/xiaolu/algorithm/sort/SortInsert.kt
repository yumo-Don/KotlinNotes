package com.xiaolu.algorithm.sort

/**
 * @Author: lollipop
 * @Time:2020/11/10
 * @Document: 插入排序
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 * 当我们需要将一个数据 a 插入到已排序区间时，需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置。
 * 找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，这样才能腾出位置给元素 a 插入。
 */
class SortInsert {

    companion object {
        private val data = arrayOf(2, 6, 4, 9, 0, 8, 7, 9)

        @JvmStatic
        fun main(args: Array<String>) {
            sortAsc()
        }

        private fun sortAsc() {
            for (index in 1 until data.size) {
                val value = data[index]
                var insertIndex = index - 1
                for (j in (index - 1) downTo 0) {
                    if (data[j] > value) {
                        data[j + 1] = data[j]
                        insertIndex = j - 1
                    } else break
                }

                data[insertIndex + 1] = value
            }
            println(data.contentToString())
        }
    }
}