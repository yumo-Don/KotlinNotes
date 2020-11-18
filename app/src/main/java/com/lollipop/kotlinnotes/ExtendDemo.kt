package com.lollipop.kotlinnotes

fun <T> T.then(block: T.() -> Unit): T {
    if (this == null) {
        return this
    }
    block()
    return this
}

fun <T> T.canContinue(param: (T) -> Boolean): T? {
    return if (param(this)) this else null
}

