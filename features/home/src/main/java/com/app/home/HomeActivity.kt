package com.app.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.firebaseapp.FirebaseApp
import com.app.home.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.setOnClickListener {
            FirebaseApp.signOut()
        }
    }
}