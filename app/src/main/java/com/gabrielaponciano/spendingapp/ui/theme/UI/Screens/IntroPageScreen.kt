package com.gabrielaponciano.spendingapp.ui.theme.UI.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.R
import com.gabrielaponciano.spendingapp.ui.theme.Components.IntroButton
import com.gabrielaponciano.spendingapp.ui.theme.Purple40
import com.gabrielaponciano.spendingapp.ui.theme.Purple80

@Composable
fun IntroPage(navController: NavController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Purple40,
                            Purple80,
                            White
                        )
                    )
                ),
            verticalArrangement = Arrangement.spacedBy(96.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logofinancial),
                    contentDescription = "",
                    modifier = Modifier.size(250.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IntroButton(title = "Login") {
                    navController.navigate("login")
                }
                IntroButton(title = "Sign Up") {
                    navController.navigate("sign")
                }
            }
        }
    }
}

@Composable
@Preview
fun IntroPagePreview(){
    IntroPage(navController = rememberNavController())
}
