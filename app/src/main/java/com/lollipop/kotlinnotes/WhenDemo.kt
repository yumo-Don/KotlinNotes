package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document: 条件选择demo
 * when的分支条件 不像 switch那么死板，一定需要常量作为分支条件，
 * when的分支条件可以为任意对象 eg:log() logFamily()
 * when表达式没有参数的时候，分支条件就是boolean类型的  eg:logContainWho()
 */
class WhenDemo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            log(Person.Dad)
            log(Person.Mom)

            logFamily(setOf(Person.Dad, Person.Mom))
            logFamily(setOf(Person.Dad, Person.Child))

            logContainWho(setOf(Person.Dad, Person.Mom))
        }

        private fun log(person: Person) {
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
    }
}

enum class Person(val personName: String, val age: Int) {

    Dad("lollipop", 27),
    Mom("dream", 26),
    Child("ym", 1);
}