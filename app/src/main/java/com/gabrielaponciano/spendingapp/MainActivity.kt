package com.gabrielaponciano.spendingapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.model.GroupCreate
import com.gabrielaponciano.spendingapp.model.GroupJoin
import com.gabrielaponciano.spendingapp.model.GroupLeave
import com.gabrielaponciano.spendingapp.model.LoginRequest
import com.gabrielaponciano.spendingapp.model.User
import com.gabrielaponciano.spendingapp.model.createSpending
import com.gabrielaponciano.spendingapp.network.ExpenseControllerApi
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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            delay(10000L)
            testRequest()
        }
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

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun testRequest() {
        try {
            // USER
            var user = User(name = "Maurício de Moura", email = "mauriciomoura837@gmail.com", password = "123")
            var createdUser = ExpenseControllerApi.createUser(user)
            var loginResponse = ExpenseControllerApi.loginUser(LoginRequest(user.email, user.password))
            val token = loginResponse.data.token

            // SPENDING
            val newSpending1 = createSpending(
                name = "Ifood",
                day = LocalDateTime.now(),
                value = 50F,
                userId = loginResponse.data.userId
            )
            val newSpending2 = createSpending(
                name = "Amazon",
                day = LocalDateTime.now(),
                value = 80F,
                userId = loginResponse.data.userId
            )
            ExpenseControllerApi.createSpendingUser(newSpending1, token)
            ExpenseControllerApi.createSpendingUser(newSpending2, token)

            var spendings = ExpenseControllerApi.getSpendingsByUserId(loginResponse.data.userId, token).data
            println(spendings)

            val editedSpending = spendings[0]
            editedSpending.value = 85.2F
            ExpenseControllerApi.updateSpendingUser(loginResponse.data.userId, editedSpending, token)

            spendings = ExpenseControllerApi.getSpendingsByUserId(loginResponse.data.userId, token).data
            println(spendings)

            // GROUP
            val newGroup = GroupCreate(
                userId = loginResponse.data.userId,
                name = "Grupo de teste",
                password = "456"
            )
            ExpenseControllerApi.createGroup(newGroup, token)

            val groups = ExpenseControllerApi.getAllGroups(token).data
            val group = ExpenseControllerApi.getGroupById(groups[0].id, token).data
            println(group)

            val groupLeave = GroupLeave(
                userId = loginResponse.data.userId,
                groupId = group.id
            )
            ExpenseControllerApi.leaveGroup(groupLeave, token)

            val groupJoin = GroupJoin(
                userId = loginResponse.data.userId,
                groupId = group.id,
                password = "456"
            )
            ExpenseControllerApi.joinGroup(groupJoin, token)
            println("Fim exemplo")
        } catch (exception: Exception) {
            Log.println(Log.ERROR, "TESTE", exception.message.toString())
        }
    }
}
