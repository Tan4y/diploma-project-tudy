package org.tues.tudy.data.remote

import org.tues.tudy.data.model.RegisterRequest
import okhttp3.ResponseBody
import org.tues.tudy.data.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<ResponseBody>

    @POST("api/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<ResponseBody>
}
