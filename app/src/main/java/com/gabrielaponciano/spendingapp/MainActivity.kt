package com.gabrielaponciano.spendingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.ui.theme.SpendingAppTheme
import com.gabrielaponciano.spendingapp.ui.theme.States.LoginUiState
import com.gabrielaponciano.spendingapp.ui.theme.States.SignUpUiState
import com.gabrielaponciano.spendingapp.ui.theme.UI.Screens.AddExpense
import com.gabrielaponciano.spendingapp.ui.theme.UI.Screens.HomeScreen
import com.gabrielaponciano.spendingapp.ui.theme.UI.Screens.IntroPage
import com.gabrielaponciano.spendingapp.ui.theme.UI.Screens.LoginScreen
import com.gabrielaponciano.spendingapp.ui.theme.UI.Screens.SignUpScreen
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.LoginViewModel
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.SignUpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendingAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "intro"){
                    composable("intro"){
                        IntroPage(navController)
                    }
                    composable("login"){
                        LoginScreen(loginViewModel = LoginViewModel(), uiState = LoginUiState(),navController)
                    }
                    composable("sign"){
                        SignUpScreen(signUpViewModel = SignUpViewModel(), uiState = SignUpUiState(), navController)
                    }
                    composable("home"){
                        HomeScreen(navController)
                    }
                    composable("add"){
                        AddExpense()
                    }
                }
                }
            }
        }
    }
