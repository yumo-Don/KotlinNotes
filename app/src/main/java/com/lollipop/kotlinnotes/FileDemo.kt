package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document: 实体类demo。自定义访问器
 */
class FileDemo {
    var name: String? = null
        set(value) {
            //isBlank 判断包括 空串 以及 空格；isEmpty判断只包括空串
            field = if (value.isNullOrBlank())
                "lollipop"
            else value
        }
        get() = if (name.isNullOrBlank()) "无名氏" else field

}