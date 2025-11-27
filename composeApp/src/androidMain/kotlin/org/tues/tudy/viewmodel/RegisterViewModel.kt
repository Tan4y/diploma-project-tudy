package org.tues.tudy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.tues.tudy.data.remote.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repo = AuthRepository()

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state

    fun register(username: String, email: String, password: String) {
        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            _state.value = RegisterState(error = "All fields are required")
            return
        }

        viewModelScope.launch {
            try {
                _state.value = RegisterState(loading = true)
                val response = repo.register(username, email, password)
                _state.value = RegisterState(success = response)
            } catch (e: Exception) {
                _state.value = RegisterState(error = e.message ?: "Unexpected error")
            }
        }
    }
}

data class RegisterState(
    val loading: Boolean = false,
    val success: String? = null,
    val error: String? = null
)
