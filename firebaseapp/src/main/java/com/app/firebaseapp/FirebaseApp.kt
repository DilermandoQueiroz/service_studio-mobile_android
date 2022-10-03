package com.app.firebaseapp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

object FirebaseApp {

    val auth: FirebaseAuth = Firebase.auth

    fun authLogin(email: String, password: String) = flow {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val resultFlow = result
        emit(LoginResult.SUCESS)
    }.flowOn(Dispatchers.IO)

    fun isLogged() : Boolean = auth.currentUser != null
}

enum class LoginResult {
    SUCESS, ERROR
}