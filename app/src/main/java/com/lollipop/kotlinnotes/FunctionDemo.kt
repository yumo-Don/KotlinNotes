package com.lollipop.kotlinnotes

/**
 * @Author: lollipop
 * @Document: 函数demo：命名参数、顶层函数、扩展函数、局部函数
 */
class FunctionDemo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            saveProduct("短裤", "20.00", "YYYYY") //=> saveProduct("短裤", "20.00", "YYYYY","",1.0)

            saveProduct("鸭舌帽", "10.00", "", "", 0.5)
            saveProduct(
                price = "30.00",
                name = "短裙",
                introduction = "ZZZZZ",
                discount = 0.8,
                type = "衣服"
            )
            saveProduct("鸭舌帽", "10.00", discount = 0.5)
        }

        private fun saveProduct(
            name: String,
            price: String,
            introduction: String = "",
            type: String = "",
            discount: Double = 1.0
        ) {
        }

    }


}