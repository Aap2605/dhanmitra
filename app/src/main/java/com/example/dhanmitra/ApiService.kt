package com.dhanmitra.network

import com.dhanmitra.models.RegisterRequest
import com.dhanmitra.models.RegisterResponse
import com.dhanmitra.models.LoginRequest
import com.dhanmitra.models.LoginResponse
import com.dhanmitra.models.OtpVerifyRequest
import com.dhanmitra.models.OtpVerifyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @POST("verify-otp")
    fun verifyOtp(@Body request: OtpVerifyRequest): Call<OtpVerifyResponse>
}
