package org.tues.tudy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.tues.tudy.ui.auth.RegisterScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "register"
    ) {
        composable("register") {
            RegisterScreen(navController)
        }
    }
}
