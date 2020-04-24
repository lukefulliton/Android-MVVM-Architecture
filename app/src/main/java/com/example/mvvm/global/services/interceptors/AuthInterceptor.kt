package com.example.mvvm.global.services.interceptors

import com.example.mvvm.global.services.ExampleService
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = runBlocking { getAccessTokenAsync() }

        val pristineRequest = chain.request()
        val requestWithAuthorizationHeader = pristineRequest.newBuilder()
                                                            .addHeader("Authorization", "Bearer $accessToken")
                                                            .build()
        return chain.proceed(requestWithAuthorizationHeader)
    }

    suspend fun getAccessTokenAsync(): String? =
        suspendCoroutine { cont ->
            //ToDo: You can put an async callback function call here.
            cont.resume(ExampleService.authManager.getAccessToken())
        }
}