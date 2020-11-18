package com.lollipop.kotlinnotes

import android.content.Context
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.runBlocking
import org.jetbrains.annotations.TestOnly

/**
 * @Author: lollipop
 * @Document: 实体类demo。自定义访问器
 */
class FieldDemo {
    var name: String? = null
        set(value) {
            //isBlank 判断包括 空串 以及 空格；isEmpty判断只包括空串
            field = if (value.isNullOrBlank())
                "lollipop"
            else value
        }
        get() = if (name.isNullOrBlank()) "无名氏" else field

}
