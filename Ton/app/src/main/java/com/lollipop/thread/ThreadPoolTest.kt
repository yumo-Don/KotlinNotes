package com.lollipop.thread

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.os.Message
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class ThreadPoolTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val newScheduledThreadPool = Executors.newScheduledThreadPool(2)
//            newScheduledThreadPool.scheduleAtFixedRate({ println(Thread.currentThread().name)
//                                                       Thread.sleep(1000)},500,500,TimeUnit.MILLISECONDS)
//
//            Thread.sleep(5000)
//            newScheduledThreadPool.shutdown()
//
//            val newScheduledThreadPool = Executors.newFixedThreadPool(2)
//            for (i in 0..10) {
//                newScheduledThreadPool.execute{
//                    println(Thread.currentThread().name)
//                    Thread.sleep(500)
//                }
//                Thread.sleep(2000)
//            }

//            Executors.newCachedThreadPool()
//
//            val thread = Thread(
//                {
//                    for (i in 1..5) {
//                        println(Thread.currentThread().name)
//                        Thread.sleep(1000)
//                    }
//                }, "thread-1"
//            )
//
//            thread.start()
//            Thread.sleep(5000)
//
//            while (true){
//                println(thread.state)
//                if (thread.state == Thread.State.TERMINATED){
//                    break
//                }
//                Thread.sleep(1000)
//            }

            var handler:Handler? = null
            val thread = Thread(
                {
                   handler = @SuppressLint("HandlerLeak")
                   object : Handler(){
                        override fun handleMessage(msg: Message) {
                            super.handleMessage(msg)
                            println(msg.what)
                        }
                    }
                    Looper.prepare()
                    Looper.loop()
                }, "thread-1"
            )

            thread.start()

            for (i in 1..5) {
                handler?.sendEmptyMessage(i)
                Thread.sleep(1000)
            }

            Thread.sleep(5000)


            while (true){
                println(thread.state)
                if (thread.state == Thread.State.TERMINATED){
                    break
                }
                Thread.sleep(1000)
            }
        }
    }

}