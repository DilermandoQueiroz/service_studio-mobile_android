package com.app.demo.presentation.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.app.demo.presentation.MainActivity
import com.app.login.presentation.LoginActivity
import com.app.navigation.AppNavigator

class AppNavigationImpl : AppNavigator{
    override fun navigate(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)    }

}