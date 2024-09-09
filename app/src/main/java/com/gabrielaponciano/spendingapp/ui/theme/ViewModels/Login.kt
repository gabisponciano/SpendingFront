package com.gabrielaponciano.spendingapp.ui.theme.ViewModels

import androidx.lifecycle.ViewModel
import com.gabrielaponciano.spendingapp.ui.theme.States.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel:ViewModel(){
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible = _isPasswordVisible.asStateFlow()

    fun loginUserName(userEmail:String){
        _uiState.update { currentState ->
            currentState.copy(
                userEmail = userEmail
            ) }
    }
    fun loginPassword(password:String){
        _uiState.update { currentState ->
            currentState.copy(
                password = password
            ) }
    }

    fun togglePasswordVisibility() {
        _isPasswordVisible.value = !_isPasswordVisible.value
    }
}