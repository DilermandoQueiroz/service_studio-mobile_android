package com.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.demo.databinding.ActivityMainBinding
import com.app.navigation.NavigatorAppTattoo
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navigator by inject<NavigatorAppTattoo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        navigator.loginNavigator(this)
    }
}