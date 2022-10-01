package com.app.login.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.app.login.presentation.LoginActivity
import com.app.navigation.LoginNavigator

class LoginNavigatorImpl: LoginNavigator {

    override fun navigate(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }
}