package com.gabrielaponciano.spendingapp.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.AddExpenseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataForm(modifier: Modifier, title:String) {
    val addExpenseViewModel = viewModel<AddExpenseViewModel>()
    val uiState by addExpenseViewModel.uiState.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        addExpenseViewModel.convertMillisToDate(it)
    } ?: ""
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = "Name", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = uiState.name , onValueChange = {addExpenseViewModel.expenseName(it)}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Amount", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Date", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = selectedDate, onValueChange = {},
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth())

        if (showDatePicker){
            Popup (onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }

            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = title)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataFormInput(modifier: Modifier, title:String) {
    val addExpenseViewModel = viewModel<AddExpenseViewModel>()
    val uiState by addExpenseViewModel.uiState.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        addExpenseViewModel.convertMillisToDate(it)
    } ?: ""
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = "Name", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Amount", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Date", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = selectedDate, onValueChange = {},
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth())

        if (showDatePicker){
            Popup (onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }

            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = title)
        }
    }
}