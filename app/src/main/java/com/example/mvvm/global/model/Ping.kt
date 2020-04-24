package com.example.mvvm.global.model

import com.example.mvvm.global.networker.ExampleParcelable
import com.example.mvvm.global.networker.toObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ping(
    @Json(name = "title") val Title: String = "Hello",
    @Json(name = "description") val Description: String = "World"
): ExampleParcelable {

    override fun toJson(): String = com.example.mvvm.global.networker.toJson(this)

    companion object {
        @JvmStatic
        fun fromJson(json: String): Ping? = toObject<Ping>(json)
    }
}