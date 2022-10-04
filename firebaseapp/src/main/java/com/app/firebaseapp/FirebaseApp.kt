package com.app.firebaseapp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.lang.Exception

object FirebaseApp {

    val auth: FirebaseAuth = Firebase.auth

    fun authLogin(email: String, password: String) = flow {
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            emit(LoginResult.SUCESS)
        } catch (e: Exception) {
            emit(LoginResult.ERROR)
        }
    }.flowOn(Dispatchers.IO)

    fun isLogged() : Boolean = auth.currentUser != null

    fun signOut() = FirebaseAuth.getInstance().signOut()
}

enum class LoginResult {
    SUCESS, ERROR
}