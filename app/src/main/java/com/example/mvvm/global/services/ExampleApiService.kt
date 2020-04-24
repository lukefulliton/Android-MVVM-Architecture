package com.example.mvvm.global.services

import com.example.mvvm.global.model.Ping
import retrofit2.Response
import retrofit2.http.GET

interface ExampleApiService {

    @GET(EXAMPLE_PING_PATH)
    suspend fun getPingExampleAsync(): Response<Ping>

    @GET("$EXAMPLE_PING_PATH/$EXAMPLE")
    suspend fun getPingExample2Async(): Response<Ping>

    companion object {
        private const val EXAMPLE_PING_PATH = "ping"
        private const val EXAMPLE = "example"
    }
}