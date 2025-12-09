package org.tues.tudy.ui.auth

import BaseColor100
import org.tues.tudy.R
import CustomTextField
import ErrorScreen
import PrimaryColor2
import SuccessScreen
import android.widget.MediaController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.tues.tudy.ui.components.CustomButton
import org.tues.tudy.ui.components.LinkButton
import org.tues.tudy.viewmodel.RegisterState
import org.tues.tudy.viewmodel.RegisterViewModel
import androidx.navigation.NavController
import org.tues.tudy.ui.components.LogoPlusTitle

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel(),
    previewState: RegisterState? = null
) {
    val state = previewState ?: viewModel.state.collectAsState().value

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var usernameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.Space100)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { focusManager.clearFocus() }
    ) {

        // MAIN CONTENT
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LogoPlusTitle("Create Account")

            Spacer(modifier = Modifier.height(Dimens.Space450))

            CustomTextField(
                value = username,
                onValueChange = {
                    username = it
                    usernameError = null
                },
                label = "Username",
                error = usernameError
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                label = "Email",
                error = emailError
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null
                },
                label = "Password",
                error = passwordError,
//                trailingIcon = {
//                    Icon(
//                        imageVector = if (passwordVisible) Icons.Default.Visibility
//                        else Icons.Default.VisibilityOff,
//                        contentDescription = null,
//                        tint = PrimaryColor1,
//                        modifier = Modifier.clickable {
//                            passwordVisible = !passwordVisible
//                        }
//                    )
//                }
            )
        }


        // BOTTOM SECTION
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.Space75)
        ) {

            val isButtonEnabled =
                username.isNotEmpty() &&
                        email.isNotEmpty() &&
                        password.isNotEmpty() &&
                        usernameError == null &&
                        emailError == null &&
                        passwordError == null &&
                        !state.loading

            CustomButton(
                value = "Create Account",
                enabled = isButtonEnabled,
                onClick = {
                    var valid = true

                    if (username.isEmpty()) {
                        usernameError = "Username is required"
                        valid = false
                    }
                    val usernameRegex = Regex("^[a-zA-Z0-9_]+$")
                    if (!username.matches(usernameRegex)) {
                        usernameError =
                            "Username can only contain letters, numbers, and underscores"
                        valid = false
                    }
                    if (email.isEmpty()) {
                        emailError = "Email is required"
                        valid = false
                    }
                    val emailRegex = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+\$")
                    if (!email.matches(emailRegex)) {
                        emailError = "Invalid email address"
                        valid = false
                    }
                    if (password.isEmpty()) {
                        passwordError = "Password is required"
                        valid = false
                    }
                    if (password.length < 8) {
                        passwordError = "Pasword must be at least 8 characters long"
                        valid = false
                    }

                    if (valid) {
                        viewModel.register(username, email, password)

                    }
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.Space25),
                horizontalArrangement = Arrangement.spacedBy(
                    Dimens.Space25,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account?",
                    style = AppTypography.Caption1,
                    color = BaseColor100
                )
                LinkButton(value = "Log In", onClick = { navController.navigate("login") })
            }
        }

        when {
            state.success != null -> {
                navController.navigate("success") {
                    popUpTo("register") { inclusive = true }
                }
                return
            }

            state.error != null -> {
                navController.navigate("error")
                return
            }
        }
    }
}
