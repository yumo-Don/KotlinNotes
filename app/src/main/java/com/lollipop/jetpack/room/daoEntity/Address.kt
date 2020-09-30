package com.lollipop.jetpack.room.daoEntity

/**
 * @Author: lollipop
 * @Time:2020/9/27
 * @Document:
 */
data class Address(
    val city: String,
    val street: String,
) {
    constructor() : this("", "")
}