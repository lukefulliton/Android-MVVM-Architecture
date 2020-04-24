package com.example.mvvm.global.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.mvvm.global.model.Ping
import com.example.mvvm.global.model.ToDo

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ToDo.mapToPing() = Ping(
    Title = this.title,
    Description = this.description
)

fun <T> MutableList<T>.mapToPing() : MutableList<Ping> {
    val pings = mutableListOf<Ping>()

    this.forEach {
        if(it is ToDo) {
            pings.add(it.mapToPing())
        }
    }

    return pings
}

