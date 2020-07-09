package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document:
 */
class BlogDemo {

}

fun B.c(){

}

fun C.c(){

}

open class B{
    open fun a(){
        print("B 的 a()")
    }

}

class C: B() {
    override fun a(){
        print("C 的 a()")

        mapOf(1 to 1)
    }
}

