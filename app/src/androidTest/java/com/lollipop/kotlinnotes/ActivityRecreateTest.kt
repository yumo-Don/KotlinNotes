package com.lollipop.kotlinnotes

import androidx.test.core.app.launchActivity
import com.lollipop.activity.MainActivity
import org.junit.Test

/**
 * @Author: lollipop
 * @Time:2020/9/18
 * @Document:
 */
class ActivityRecreateTest {
    @Test
    fun activityRecreate(){
        val scenario = launchActivity<MainActivity>()
        scenario.recreate()
    }
}
