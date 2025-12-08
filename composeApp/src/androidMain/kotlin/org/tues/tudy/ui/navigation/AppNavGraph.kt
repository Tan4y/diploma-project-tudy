package org.tues.tudy.ui.navigation

import ErrorScreen
import SuccessScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.tues.tudy.ui.auth.RegisterScreen
import org.tues.tudy.ui.auth.LogInScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "register"
    ) {
        composable("register") {
            RegisterScreen(navController)
        }

        composable("success") {
            SuccessScreen(
                title = "Account Created!",
                description = "Your account has been successfully registered.",
                onButtonClick = {
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }

        composable("error") {
            ErrorScreen (
                title = "Create Account Unsuccessful!",
                description = "There was an error while trying create account.",
                onButtonClick = {
                    navController.navigate("register") {
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }

        composable("login") {
            LogInScreen(navController)
        }
    }
}
