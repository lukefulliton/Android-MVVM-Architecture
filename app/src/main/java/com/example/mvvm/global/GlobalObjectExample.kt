package com.example.mvvm.global

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction0

object GlobalObjectExample {
    private val job = SupervisorJob()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    fun setSomething(callback: KFunction0<Unit>? = null) {
        setSomethingOnTheServer(callback)
    }

    private fun setSomethingOnTheServer(callback: KFunction0<Unit>? = null) {
        uiScope.launch {
            Log.d("GlobalObjectExample.setSomethingOnTheServer", "callback")

            if(callback != null) {
                callback()
            }
        }
    }
}