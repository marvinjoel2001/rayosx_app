package com.example.rayosx.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rayosx.ui.theme.auth.AuthViewModel
import com.example.rayosx.ui.theme.auth.LoginScreen
import com.example.rayosx.ui.theme.auth.SignupScreen
import com.example.rayosx.ui.theme.home.HomeScreen


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel,navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel,navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel,navController)
        }
    }
}