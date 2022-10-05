package com.app.login.presentation.intro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.firebaseapp.FirebaseApp
import com.app.login.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
        val user = FirebaseApp.auth.currentUser.toString()
        val userName = FirebaseApp.auth.currentUser?.email.toString()
        Log.d("TAG_FIREBASE", user)
        Log.d("TAG_FIREBASE", userName)
    }
    private fun setButton() = with(binding) {
        btnLogin.setOnClickListener {
            findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToLoginFragment())
        }
        btnRegister.setOnClickListener {
            findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToRegisterFragment())
        }
    }
}