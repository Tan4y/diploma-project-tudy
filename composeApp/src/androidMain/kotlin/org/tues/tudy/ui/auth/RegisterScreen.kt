package org.tues.tudy.ui.auth

import CustomTextField
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.tues.tudy.viewmodel.RegisterState
import org.tues.tudy.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    previewState: RegisterState? = null
) {
    val state = previewState ?: viewModel.state.collectAsState().value

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Error states for each field
    var usernameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Create Account", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // USERNAME
        CustomTextField(
            value = username,
            onValueChange = {
                username = it
                usernameError = null // clear error on typing
            },
            label = "Username",
            error = usernameError
        )

        Spacer(modifier = Modifier.height(20.dp))

        // EMAIL
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

        // PASSWORD
        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = "Password",
            error = passwordError
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Validate all fields on submit
                var valid = true

                if (username.isEmpty()) {
                    usernameError = "Username is required"
                    valid = false
                }
                if (email.isEmpty()) {
                    emailError = "Email is required"
                    valid = false
                }
                if (password.isEmpty()) {
                    passwordError = "Password is required"
                    valid = false
                }

                if (valid) {
                    viewModel.register(username, email, password)
                }
            },
            enabled = !state.loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (state.loading) "Creating account..." else "Create Account")
        }

        state.error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        state.success?.let {
            Text(text = it, color = MaterialTheme.colorScheme.primary)
        }
    }
}
