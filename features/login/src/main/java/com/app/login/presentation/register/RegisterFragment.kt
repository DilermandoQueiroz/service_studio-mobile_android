package com.app.login.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.login.databinding.FragmentRegisterBinding
import com.app.navigation.AppNavigator
import com.app.navigation.LoginNavigator
//import com.app.demo.presentation.navigation.NavigatorAppTattoo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment()  {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModel<RegisterViewModel>()
    private val navigator by inject<AppNavigator>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
    }

    private fun setButton() = with(binding) {
        button.setOnClickListener {
            viewModel.setRegisterClick()
        }
    }
}