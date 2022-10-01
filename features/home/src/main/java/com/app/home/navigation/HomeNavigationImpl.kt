package com.app.home.navigation

import android.content.Context
import android.content.Intent
import com.app.home.HomeActivity
import com.app.navigation.HomeNavigator

class HomeNavigationImpl : HomeNavigator {
    override fun navigate(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}