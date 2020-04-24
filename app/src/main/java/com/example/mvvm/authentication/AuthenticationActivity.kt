package com.example.mvvm.authentication

import android.os.Bundle
import com.example.mvvm.R
import com.example.mvvm.global.GlobalObjectExample

class AuthenticationActivity: AuthAwareActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        authorizationCheck()
    }

    fun authorizationCheck() {
        val authHandler = authenticationHandler

        if(authHandler != null && intent.getBooleanExtra(LOGOUT, false)){
            authHandler.logout()
        } else if (authHandler != null && authHandler.hasValidCredentials) {
            GlobalObjectExample.setSomething(authHandler::showNextActivity)
        } else {
            authHandler?.startAuthenticationProcess()
        }
    }

    companion object {
        val LOGOUT = "LOGOUT"
    }
}