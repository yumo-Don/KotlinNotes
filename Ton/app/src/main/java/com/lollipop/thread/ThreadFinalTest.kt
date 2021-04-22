package com.lollipop.thread

class ThreadFinalTest {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val person = Person("THC")
            test(person)
        }

        private fun test(person: Person) {
            Thread{person.name = "YM"}
            Thread {
                person.name = ""
            }
        }

    }
}

class Person(var name:String)