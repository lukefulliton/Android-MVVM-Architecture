package com.example.mvvm.global.networker

import com.squareup.moshi.Moshi

interface ExampleParcelable {
    fun toJson(): String
}

inline fun <reified T> toObject(json: String): T? {
    return Moshi.Builder().build().adapter<T>(T::class.java).fromJson(json)
}

inline fun <reified T> toJson(`object`: T): String {
    return Moshi.Builder().build().adapter(T::class.java).toJson(`object`)
}