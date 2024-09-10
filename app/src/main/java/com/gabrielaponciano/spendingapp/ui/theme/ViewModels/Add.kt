package com.gabrielaponciano.spendingapp.ui.theme.ViewModels

import androidx.compose.material3.DatePickerState
import androidx.lifecycle.ViewModel
import com.gabrielaponciano.spendingapp.ui.theme.States.AddExpenseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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


    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }

}

