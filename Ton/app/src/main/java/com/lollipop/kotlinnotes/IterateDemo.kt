package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document: 迭代demo
 * do while 循环
 * for循环 集合区间迭代
 * map迭代
 */
class IterateDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            whileDemo(3, 10, 1)
//            a(3, 10, 1)

//            fizzBuzz()

//            mapIterate()

            listIterate()
        }

        /**
         * do-while（false）
         * do-while一般我们用于循环处理，false的话100%不会循环，那我们为什么要用do-while呢？
         * 因为do-while（false）可以很好的帮我们减少条件判断嵌套
         */
        private fun whileDemo(a: Int, b: Int, c: Int) {
            do {
                if (a < 1)
                    break
                if (b < 1)
                    break
                if (b > 10) {
                    println(a + b)
                    break
                }
                if (c < 100) {
                    println(a + b + c)
                    break
                }
                println(a + c)
            } while (false)
            println("结束啦")
        }

        private fun a(a: Int, b: Int, c: Int) {
            if (a > 0) {
                if (b > 0) {
                    if (b > 10) {
                        println(a + b)
                    } else {
                        if (c < 100) {
                            println(a + b + c)
                        } else {
                            println(a + c)
                        }
                    }
                }
            }
            println("结束啦")
        }

        /**
         * 区间迭代
         */
        private fun fizzBuzz() {
            for (i in 1..100) {
                when {
                    i % 3 == 0 && i % 5 == 0 -> println("fizzBuzz")
                    i % 3 == 0 -> println("fizz")
                    i % 5 == 0 -> println("buzz")
                    else -> println(i)
                }
            }
        }

        /**
         * map 迭代，在迭代语句中可以把key value直接存储在变量中，
         */
        private fun mapIterate() {
            val map = HashMap<Char, String>()
            for (i in 'A'..'Z') {
                map[i] = Integer.toBinaryString(i.toInt())
            }

            for ((key, value) in map) {
                println("key : $key || value :$value")
            }
        }

        /**
         * list 带下标迭代
         */
        private fun listIterate() {
            val list = arrayListOf("A","B","C")
            for ((index, element) in list.withIndex()) {
                println("index : $index -> $element")
            }
        }
    }
}