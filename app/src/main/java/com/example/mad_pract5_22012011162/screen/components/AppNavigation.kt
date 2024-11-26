package com.example.mad_pract5_22012011162.screen.components

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(context: Context, navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(navController = navController, startDestination = "login")
    {
        composable("login")
        {
            LoginScreen(context,
                navController = navController,
            )
        }
        composable("registration") {
            RegistrationScreen(context,
                navController = navController,
            )
        }
    }
}
