package com.lollipop.kotlinnotes

import java.util.*

/**
 * @Author: lollipop
 * @Document: 函数的声明 & 函数返回值
 */
class ExpressionDemo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun max(a: Int, b: Int): Int {
            return a.coerceAtLeast(b)
        }

        /**
         * 表达式体函数 可以省略返回类型
         */
        fun maxTwo(a: Int, b: Int) = a.coerceAtLeast(b)


        /**
         * 代码块体函数 必须显式地写出返回类型
         */
        fun maxThree(a: Int, b: Int): Int {
            return a.coerceAtLeast(b)
        }
    }
}