package com.app.demo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.demo.R
import com.app.demo.databinding.FragmentMainBinding
import com.app.demo.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }
}