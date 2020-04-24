package com.example.mvvm.authentication

import android.content.Intent
import com.example.mvvm.MainActivity
import com.example.mvvm.global.GlobalObjectExample

class AuthenticationHandler(originalActivity: AuthAwareActivity) {
    private val originalActivity: AuthAwareActivity = originalActivity
    val hasValidCredentials = true

    fun startAuthenticationProcess() {
        GlobalObjectExample.setSomething(::showNextActivity)
    }

    fun logout() {
        originalActivity.finishAffinity()
    }

    fun showNextActivity() {
        val intent = Intent(originalActivity, MainActivity::class.java)
        originalActivity.startActivity(intent)
        originalActivity.finish()
    }
}