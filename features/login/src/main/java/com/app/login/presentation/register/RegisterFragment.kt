package com.app.login.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.login.databinding.FragmentRegisterBinding
import com.app.login.domain.register.RegisterResult
import com.app.navigation.AppNavigator
import com.app.navigation.HomeNavigator
import com.app.navigation.LoginNavigator
import kotlinx.coroutines.launch
//import com.app.demo.presentation.navigation.NavigatorAppTattoo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment()  {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModel<RegisterViewModel>()
    private val navigatorHome by inject<HomeNavigator>()

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
        observerViewModel()
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            viewModel.loginResult.collect {
                when(it){
                    is LoginResult.Success -> navigateSuccess()
                    is LoginResult.Error -> renderError(it.message)
                    is LoginResult.Loading -> binding.progress.isVisible = it.isLoading
                }
            }
        }
    }

    private fun renderError(erroMessage: String) {
        Toast.makeText(requireContext(), erroMessage, Toast.LENGTH_SHORT).show()
    }

    private fun setButton() = with(binding) {
        button.setOnClickListener {
            val user = UserModel(
                name = textName.text.toString(),
                email = textEmail.text.toString()
            )
            viewModel.setRegisterClick(user, textPassword.text.toString())
        }
        textTerms.setOnClickListener {
            navigatorHome.navigate(requireContext())
        }
    }

    private fun navigateSuccess() {
        navigatorHome.navigate(requireContext())
    }
}