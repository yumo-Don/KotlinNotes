package com.lollipop.kotlinnotes

object ObjectDemo {

    fun test() {
        UserInfoInstance.isVip()
    }
}

object UserInfoInstance {
    var name: String = ""
    var address: String = ""
    var vipLevel: Int = 0

    fun isVip() = vipLevel > 0
}

class A {

    private fun test() {

    }

    companion object {

        private fun z() {

        }
    }
}