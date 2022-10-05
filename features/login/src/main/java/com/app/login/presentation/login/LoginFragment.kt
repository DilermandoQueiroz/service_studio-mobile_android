package com.app.login.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.app.firebaseapp.domain.LoginResult
import com.app.login.databinding.FragmentLoginBinding
import com.app.navigation.HomeNavigator
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()
    private val navigatorHome by inject<HomeNavigator>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
        observerViewModel()
    }
    private fun setButton() = with(binding) {
        button.setOnClickListener {
            viewModel.logging(textEmail.text.toString(), textPassword.text.toString())
        }
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
    private fun navigateSuccess() {
        navigatorHome.navigate(requireContext())
    }
}