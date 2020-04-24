package com.example.mvvm.global.networker

import com.example.mvvm.global.model.Ping
import com.example.mvvm.global.services.ExampleService
import retrofit2.Response

object ExampleNetworker {

    suspend fun getPingAsync(): Response<Ping> {
        return ExampleService.exampleAPI.getPingExampleAsync()
    }

    suspend fun getPingExample2Async(): Response<Ping> {
        return ExampleService.exampleAPI.getPingExample2Async()
    }
}