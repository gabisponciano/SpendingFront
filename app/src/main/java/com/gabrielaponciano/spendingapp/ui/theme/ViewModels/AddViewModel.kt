package com.gabrielaponciano.spendingapp.ui.theme.ViewModels

import androidx.lifecycle.ViewModel
import com.gabrielaponciano.spendingapp.ui.theme.States.AddExpenseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddExpenseViewModel: ViewModel(){

    private val _uiState: MutableStateFlow<AddExpenseUiState> = MutableStateFlow(AddExpenseUiState())
    val uiState = _uiState.asStateFlow()

    private val _expenses = MutableStateFlow<List<AddExpenseUiState>>(emptyList())
    val expenses: StateFlow<List<AddExpenseUiState>> = _expenses

    fun addExpense(expense: AddExpenseUiState) {
        _expenses.value += expense
    }

    fun expenseName(name:String){
        _uiState.update { currentState ->
            currentState.copy(
                name = name
            ) }
    }
    fun expenseDate(date: Long?){
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


    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }

}

