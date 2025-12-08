package org.tues.tudy.ui.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.tues.tudy.ui.components.LogoPlusTitle
import org.tues.tudy.viewmodel.RegisterState
import org.tues.tudy.viewmodel.RegisterViewModel

@Composable
fun LogInScreen (
    navController: NavController,
    viewModel: RegisterViewModel = viewModel(),
    previewState: RegisterState? = null
) {
    LogoPlusTitle("Log In")
}