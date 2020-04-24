package com.example.mvvm.global.services

import com.example.mvvm.BuildConfig
import com.example.mvvm.global.model.AuthManager
import com.example.mvvm.global.services.interceptors.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ExampleService {
    val exampleAPI by lazy { create<ExampleApiService>("${BuildConfig.BASE_API_URL}/v${BuildConfig.API_VERSION}") }
    val authManager = AuthManager()

    private inline fun <reified T> create(baseUrl: String): T = Retrofit.Builder()
        .client(buildClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
        .create(T::class.java)


    private fun buildClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }
}