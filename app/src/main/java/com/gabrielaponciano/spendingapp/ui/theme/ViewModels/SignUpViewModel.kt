package com.gabrielaponciano.spendingapp.ui.theme.ViewModels

import androidx.lifecycle.ViewModel
import com.gabrielaponciano.spendingapp.ui.theme.States.SignUpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel:ViewModel(){
    private val _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible = _isPasswordVisible.asStateFlow()

    fun SignUpUserName(userEmail:String){
        _uiState.update { currentState ->
            currentState.copy(
                userEmail = userEmail
            ) }
    }

    fun SignUpEmail(userEmail:String){
        _uiState.update { currentState ->
            currentState.copy(
                userEmail = userEmail
            ) }
    }

    fun SignUpPassword(password:String){
        _uiState.update { currentState ->
            currentState.copy(
                password = password
            ) }
    }

    fun togglePasswordVisibility() {
        _isPasswordVisible.value = !_isPasswordVisible.value
    }
}
