package com.example.mvvm.global.interfaces.callbacks

interface NavCallback<T> {
    fun nav(customModel: T) { }
    fun nav() { }
    fun navBack() { }
    fun anotherNavAction() { }
}