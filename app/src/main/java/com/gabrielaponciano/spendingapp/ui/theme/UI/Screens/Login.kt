package com.gabrielaponciano.spendingapp.ui.theme.UI.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.ui.theme.BackField
import com.gabrielaponciano.spendingapp.ui.theme.Components.BottomButton
import com.gabrielaponciano.spendingapp.ui.theme.Purple40
import com.gabrielaponciano.spendingapp.ui.theme.States.LoginUiState
import com.gabrielaponciano.spendingapp.ui.theme.TextFieldBackground
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(loginViewModel: LoginViewModel, uiState: LoginUiState, navController: NavController){
    val uiState by loginViewModel.uiState.collectAsState()
    val passwordVisible by loginViewModel.isPasswordVisible.collectAsState()
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Login", fontWeight = FontWeight.Bold)},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.Close , contentDescription = "Fechar")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White))
        },
        bottomBar = {
            BottomButton(title = "Fazer Login") {
                navController.navigate("home")
            }
        }
    ){ paddingValues ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
        ){
            HorizontalDivider(modifier = Modifier.height(96.dp))
            OutlinedTextField(
                value = uiState.userEmail,
                onValueChange = { loginViewModel.loginUserName(it)

                },
                label = { Text(text = "Email") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                modifier = Modifier.width(320.dp)
            )
            OutlinedTextField(
                value = uiState.password,
                onValueChange = { loginViewModel.loginPassword(it)
                },
                label = { Text(text = "Senha") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                modifier = Modifier.width(320.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) Icons.Default.Check else Icons.Default.Close
                    IconButton(onClick = { loginViewModel.togglePasswordVisibility() }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Text(text = "Esqueceu sua senha?",
                fontSize = 16.sp,

                fontWeight = FontWeight.SemiBold,
                color = Purple40
            )
    }
    }
}
@Preview
@Composable
fun loginPreview(){
    LoginScreen(loginViewModel = LoginViewModel(), uiState = LoginUiState(), rememberNavController())
}