package com.app.firebaseapp

import android.net.Uri
import android.util.Log
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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

    val auth: FirebaseAuth = Firebase.auth
    val user: FirebaseUser? = Firebase.auth.currentUser

    fun authLogin(user: UserModel, password: String) = flow {
        try {
            auth.createUserWithEmailAndPassword(user.email, password).await()
            Log.d("TAG_FIREBASE", "CREATE")
            updateProfile(user)
                .catch {
                    Log.d("TAG_FIREBASE", "ERRO UPDATE")
                    emit(LoginResult.Error("Update Error"))
                }
                .collect{
                    Log.d("TAG_FIREBASE", "Success CREATE")
                    emit(LoginResult.Success)
                }
        } catch (e: Exception) {
            Log.d("TAG_FIREBASE", "ERRO CREATE")
            emit(LoginResult.Error("Login Error"))
        }
    }.flowOn(Dispatchers.IO)

    fun isLogged(): Boolean = auth.currentUser != null

    fun signOut() = auth.signOut()

    fun updateProfile(userData: UserModel) = flow {
        val profileUpdates = userProfileChangeRequest {
            displayName = userData.name
            photoUri = Uri.parse(userData.image)
            Log.d("TAG_FIREBASE", "PROFILE")
        }
        try {
            user?.updateProfile(profileUpdates)?.await()
            Log.d("TAG_FIREBASE", user?.displayName.toString())
            Log.d("TAG_FIREBASE", user?.email.toString())
            Log.d("TAG_FIREBASE", user?.photoUrl.toString())
            emit(LoginResult.Success)
        } catch (e: Exception) {
            emit(LoginResult.Error(""))
        }
    }

}
