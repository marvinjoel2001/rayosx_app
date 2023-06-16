package com.example.rayosx.data.remote.firebase
import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneAuthManager {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun startPhoneNumberVerification(phoneNumber: String, callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Número de teléfono a verificar
            .setTimeout(60L, TimeUnit.SECONDS) // Tiempo de espera y unidad
            .setActivity(Activity()) // Reemplaza "Activity()" con la referencia a tu actividad
            .setCallbacks(callbacks) // Callbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}