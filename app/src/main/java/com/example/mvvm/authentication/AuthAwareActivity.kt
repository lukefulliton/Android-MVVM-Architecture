package com.example.mvvm.authentication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AuthAwareActivity :AppCompatActivity() {
    var authenticationHandler: AuthenticationHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authenticationHandler = AuthenticationHandler(this)
    }
}