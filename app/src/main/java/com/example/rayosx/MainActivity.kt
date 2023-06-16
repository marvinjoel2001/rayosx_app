package com.example.rayosx


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.rayosx.navigation.AppNavHost
import com.example.rayosx.ui.theme.AppTheme
import com.example.rayosx.ui.theme.auth.AuthViewModel
import com.example.rayosx.ui.theme.auth.LoginScreen
import com.example.rayosx.ui.theme.viewmodel.LoginViewModel
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel> ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AppTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
