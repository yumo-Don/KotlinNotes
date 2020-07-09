package com.lollipop.kotlinnotes

import com.lollipop.test.Person as People

/**
 * @Author: lollipop
 * @Document: 关键字as的使用
 */
class AsDemo {

    /**
     * 类型转换（as关键字其实无需使用）
     */
    private fun isString(obj: Any): Boolean {
        return if (obj is String) {
            //此处我们可以看到，对于java来说，转换是必须的，
            // 但对于kotlin来说，我们在通过is 关键字检查后，就无需转换了，kotlin已经帮我们转换好了
            (obj as String).firstChar()
            println("$obj is String && first char is${obj.firstChar()}")
            true
        } else {
            println("$obj is not String ")
            false
        }
    }

    /**
     * 通过as关键字，修改导入的函数的名字，当我们在同一个文件内，使用不同包下的不同类或者类的方法时，会十分优雅
     * eg: 我们先使用了com.lollipop.kotlinnotes.Person的枚举类，
     *  后面我们发现我们还需要使用com.lollipop.test.Person数据类，
     *  此时我们用两种方案，1：test.person使用全名，但不优雅
     *  2：我们在导入test.person类的时候，用as关键字修改一下类名(比如修改成People)，会优雅很多
     *
     */
    private fun changeMethodNameUseAs(str: String) {
        Person.Dad
        //方式1
        com.lollipop.test.Person("lollipop")

        //方式二
        People("lollipop")
    }
}