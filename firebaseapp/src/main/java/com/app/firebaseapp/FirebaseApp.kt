package com.app.firebaseapp

import android.net.Uri
import android.util.Log
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.firebaseapp.utils.Constants.TAG_FIREBASE
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.lang.Exception

object FirebaseApp {

    val auth: FirebaseAuth get() = Firebase.auth
    val user: FirebaseUser? get() = Firebase.auth.currentUser

    fun isLogged(): Boolean = auth.currentUser != null

    fun signOut() {
        auth.signOut()
        Log.d(TAG_FIREBASE, "LOGOUT")
    }

    fun createUserWithEmailAndPassword(user: UserModel, password: String) = flow {
        try {
            auth.createUserWithEmailAndPassword(user.email, password).await()
            Log.d(TAG_FIREBASE, "CREATE")
            updateProfile(user)
                .catch {
                    Log.d(TAG_FIREBASE, "ERRO UPDATE")
                    emit(LoginResult.Error("Update Error"))
                }
                .collect{
                    Log.d(TAG_FIREBASE, "Success CREATE")
                    emit(it)
                }
        } catch (e: Exception) {
            Log.d(TAG_FIREBASE, "ERRO_CREATE")
            when(e) {
                is FirebaseAuthUserCollisionException -> emit(LoginResult.Error("Voce ja possui uma conta"))
                is FirebaseAuthWeakPasswordException -> emit(LoginResult.Error("Senha fraca"))
                is FirebaseAuthInvalidCredentialsException -> emit(LoginResult.Error("Email inválido"))
                else -> emit(LoginResult.Error("Login Error"))
            }
        }
    }.flowOn(Dispatchers.IO)

    fun loginUserWithEmailAndPassword(email: String, password: String) = flow {
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            emit(LoginResult.Success)
            Log.d(TAG_FIREBASE, "Logged")
        } catch (e: Exception) {
            Log.d(TAG_FIREBASE, "ERRO_CREATE")
            Log.d(TAG_FIREBASE, e.message.toString())
            when(e) {
                is FirebaseAuthWeakPasswordException -> emit(LoginResult.Error("Senha fraca"))
                is FirebaseAuthInvalidCredentialsException -> emit(LoginResult.Error("Senha inválida"))
                is FirebaseAuthInvalidUserException -> emit(LoginResult.Error("Conta invalida"))
                is FirebaseAuthUserCollisionException -> emit(LoginResult.Error("Conta invalida"))
                else -> emit(LoginResult.Error( e.message.toString()))
            }
        }
    }.flowOn(Dispatchers.IO)

    private fun updateProfile(userData: UserModel) = flow {
        val profileUpdates = userProfileChangeRequest {
            displayName = userData.name
            photoUri = Uri.parse(userData.image)
            Log.d(TAG_FIREBASE, "PROFILE")
        }
        try {
            user?.updateProfile(profileUpdates)?.await()
            Log.d(TAG_FIREBASE, user?.displayName.toString())
            Log.d(TAG_FIREBASE, user?.email.toString())
            Log.d(TAG_FIREBASE, user?.photoUrl.toString())
            emit(LoginResult.Success)
        } catch (e: Exception) {
            emit(LoginResult.Error("ERROR_UPDATE"))
        }
    }
}
