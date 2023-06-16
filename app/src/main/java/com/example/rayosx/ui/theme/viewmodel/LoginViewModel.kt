package com.example.rayosx.ui.theme.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rayosx.data.remote.firebase.PhoneAuthManager
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class LoginViewModel(private val context: Context) : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun validateCredentials(phoneNumber: String, password: String) {
        // Realiza la validación en Firebase
        FirebaseApp.initializeApp(context)
        firebaseAuth.signInWithEmailAndPassword(phoneNumber, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // La autenticación fue exitosa
                    _loginResult.value = LoginResult.Success
                } else {
                    // La autenticación falló
                    _loginResult.value = LoginResult.Error("Error de autenticación")
                }
            }
    }
}

sealed class LoginResult {
    object Success : LoginResult()
    data class Error(val message: String) : LoginResult()
}
