package com.lollipop.kotlinnotes

import android.util.Log
import kotlin.math.abs

/**
 * @Author: lollipop
 * @Document: 条件选择demo
 * when的分支条件 不像 switch那么死板，一定需要常量作为分支条件，
 * when的分支条件可以为任意对象 eg:log() logFamily()
 * when表达式没有参数的时候，分支条件就是boolean类型的  eg:logContainWho()
 * https://www.jianshu.com/p/3af5411371c4
 */
class WhenDemo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            log(Person.Dad)
//            log(Person.Mom)
//
//            logFamily(setOf(Person.Dad, Person.Mom))
//            logFamily(setOf(Person.Dad, Person.Child))
//
//            logContainWho(setOf(Person.Dad, Person.Mom))

            val map = object :HashMap<String,String>(){
                init {
                    "1" to "2"
                }
            }

            val z = HashMap<String,String>(2)


            val  a = Array(2){}
            println("${map["1"]}")
        }

        private fun log(person: Person) {
            person.age = 1
            when (person) {
                Person.Dad -> {
                    println(" this is Dad \"${person.personName}\"")
                }
                Person.Mom -> {
                    println(" this is Mom ${person.personName}")
                }
                Person.Child -> {
                    println(" this is Child ${person.personName}")
                }
            }
        }


        private fun logFamily(family: Set<Person>) {
            when (family) {
                setOf(Person.Dad, Person.Mom) -> println(" this is dad & mom")
                setOf(Person.Dad, Person.Child) -> println(" this is dad & child")
                setOf(Person.Mom, Person.Child) -> println(" this is mom & child")
            }
        }

        private fun logContainWho(family: Set<Person>) {
            when {
                Person.Child in family -> println(" this data contain child")
                Person.Dad in family -> println(" this data contain dad")
            }
        }

        fun log(any: Any) {
            when (any) {
                //分支条件为常量
                "1" -> print("输入的内容为数字1")

                //分支条件为boolean值
                is String -> print("输入的内容是String类型的任意变量")

                //分支条件为集合
                setOf("0", "A") -> print("输入的内容是数字0和字母A的集合")

                //分支条件为枚举类中常量的字段
                Person.Dad.personName -> print("输入的内容是枚举类Person中变量Dad的姓名")
            }
        }

        fun log(num: Int): Int = when {
            num < 0 -> abs(num)

            num < 10 -> num + 2
            else -> {
                print("当前值大于10，需返回")
                num * 2
            }
        }

    }
}

enum class Person(val personName: String, var age: Int) {

    Dad("lollipop", 27),
    Mom("dream", 26),
    Child("ym", 1);
}