package com.gabrielaponciano.spendingapp.ui.theme.ViewModels

import androidx.lifecycle.ViewModel
import com.gabrielaponciano.spendingapp.ui.theme.States.AddExpenseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddExpenseViewModel: ViewModel(){

    private val _uiState: MutableStateFlow<AddExpenseUiState> = MutableStateFlow(AddExpenseUiState())
    val uiState = _uiState.asStateFlow()

    fun expenseName(name:String){
        _uiState.update { currentState ->
            currentState.copy(
                name = name
            ) }
    }
    fun expenseDate(date:Long){
        _uiState.update { currentState ->
            currentState.copy(
                date = date
            ) }
    }
    fun expenseValue(value:Float){
        _uiState.update {currentState ->
            currentState.copy(
                value = value
            )
        }
    }

    fun inputName(nameInput:String){
        _uiState.update { currentState ->
            currentState.copy(
                nameInput = nameInput
            ) }
    }
    fun inputDate(dateInput:Long){
        _uiState.update { currentState ->
            currentState.copy(
                dateInput = dateInput
            ) }
    }
    fun inputValue(valueInput:Float){
        _uiState.update {currentState ->
            currentState.copy(
                valueInput = valueInput
            )
        }
    }
}