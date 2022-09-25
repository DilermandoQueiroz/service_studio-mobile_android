package com.app.navigation

import android.content.Context
import android.content.Intent
import com.app.login.presentation.LoginActivity

class NavigatorImpl : NavigatorAppTattoo {

    override fun loginNavigator(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

}