@file:JvmName(name = "TopNewName")

package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document: 顶层函数，顶层属性
 * 顶层函数编译生成的类名，对应包含它的文件的名字，
 * 这个文件中的所有顶层函数都会编译为这个类的静态函数
 * eg：topOne（）编译生成的类，就是TopFunctionKT
 * 如果想修改这个类的名字，可以使用@file:JvmName注解，需注意此注解需要放在包名的前面
 *
 *
 * 顶层属性和顶层函数一样，如果想像java一样，声明一个static final的常量。可以用const修饰符
 */

const val LOG_TAG = "lollipopKotlin"

fun topOne() {
    val name = "lollipop"
    name.firstChar()
}

/**
 * 扩展函数
 */
fun String.firstChar(): Char {
    return this[0]
}