package org.tues.tudy.data.remote

import org.tues.tudy.data.model.LoginRequest
import org.tues.tudy.data.model.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository {

    private val api = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5050/")     // ⚠ if testing on a phone, change this to your local IP
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun register(username: String, email: String, password: String): String {
        val response = api.register(RegisterRequest(username, email, password))

        if (response.isSuccessful) {
            return "Check your email to verify your account"
        } else {
            val error = response.errorBody()?.string()
            return error ?: "Unknown error"
        }
    }

    suspend fun login(username: String, password: String): String {
        val response = api.login(LoginRequest(username, password))

        if (response.isSuccessful) {
            return "Check your email to verify your account"
        } else {
            val error = response.errorBody()?.string()
            return error ?: "Unknown error"
        }
    }
}
