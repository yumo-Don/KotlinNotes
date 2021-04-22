package com.lollipop.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.lollipop.kotlinnotes.LOG_TAG

/**
 * @Author: lollipop
 * @Time:2020/9/21
 * @Document:
 */
class LollipopObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(LOG_TAG,"$source ON_CREATE")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d(LOG_TAG,"$source ON_RESUME")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(LOG_TAG,"$source ON_PAUSE")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d(LOG_TAG,"$source ON_DESTROY")
            }
            else -> {}
        }
    }
}