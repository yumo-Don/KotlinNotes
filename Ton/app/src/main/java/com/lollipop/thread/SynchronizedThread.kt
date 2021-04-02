package com.lollipop.thread


class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            lockDiffObject()

            lockClass()

            lockCommonObject()

            lockCommonObject2()
        }

        /**
         * 类锁
         */
        private fun lockClass() {
            val thread1 = Thread({ A.print() }, "thread-1")
            val thread2 = Thread({ A.print() }, "thread-2")
            thread1.start()
            thread2.start()
        }

        /**
         * 对象锁 不同对象
         */
        private fun lockDiffObject() {
            val thread1 = Thread({ A().print() }, "thread-1")
            val thread2 = Thread({ A().print() }, "thread-2")
            thread1.start()
            thread2.start()
        }

        /**
         * 对象锁 相同对象
         */
        private fun lockCommonObject() {
            val a = A()
            val thread1 = Thread({ a.print() }, "thread-1")
            val thread2 = Thread({ a.print() }, "thread-2")
            thread1.start()
            thread2.start()
        }

        /**
         * 对象锁 相同对象
         */
        private fun lockCommonObject2() {
            val a = A()
            val thread1 = Thread({ a.print2() }, "thread-1")
            val thread2 = Thread({ a.print2() }, "thread-2")
            thread1.start()
            thread2.start()
        }
    }


}

class A {
    companion object {
        @Synchronized
        fun print() {
            for (i in 1..5) {
                println(Thread.currentThread().name.plus("  $i"))
            }
        }
    }

    fun print() {
        synchronized(this) {
            for (i in 1..5) {
                println(Thread.currentThread().name.plus("  $i"))
            }
        }
    }

    @Synchronized
    fun print2() {
        for (i in 1..5) {
            println(Thread.currentThread().name.plus("  $i"))
        }
    }
}
