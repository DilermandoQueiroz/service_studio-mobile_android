package com.app.login.presentation.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }
    private fun setButton() = with(binding) {
        btnLogin.setOnClickListener {
//            findNavController().navigate(IntroFragmentDirectionDirections.actionOnboardingFragmentToLoginFragment())
        }
        btnRegister.setOnClickListener {
//            findNavController().navigate(IntroFragmentDirections.actionOnboardingFragmentToRegisterFragment())
        }
    }
}